package Demo2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

class MainFrame extends JFrame implements Runnable {
	public JButton toEnglish,toChinese,btnA,btnB,btnC,btnD,comfirm;
	public JLabel A,B,C,D,showText,true_or_false,finalText,left_to_done,right_done;
	public JTextField inputField;
	String true_answer = null;
	String[] English_words = {"oblige","compassion","vicinity","trample","vacant",
			"qualification","verge","submarine","segmentation","refine"};
	String[] Chinese_words = {"迫使","同情心","附近","践踏","空的","资格","边缘","潜艇","分割","精炼"};
	public String[] word = new String[4];
	int test_time=10,right=0;  // test_time用于计数（运行10次） right判定对的题数
	class giveWord extends Thread{
		double Random1 = Math.random()*10;
		int random1 = (int)Random1; // 生成随机数random1，决定了初次选出的单词组
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(test_time>0){
				random1 = (random1+1)%10; // 从选中位置不断选出下一组，直到10组单词都选完
				double Random2 = (Math.random()*10)%4;
				int random2 = (int)Random2; // 生成随机数random2，random2作为选项的下标决定了哪个是正确的单词				
				word[random2] = English_words[random1];
				word[(random2+1)%4] = English_words[(random1+1)%10];
				word[(random2+2)%4] = English_words[(random1+2)%10];
				word[(random2+3)%4] = English_words[(random1+3)%10];
				showText.setText(Chinese_words[random1]); // 设置显示的中文（英文）
				btnA.setText(word[0]);
				btnB.setText(word[1]);
				btnC.setText(word[2]);
				btnD.setText(word[3]); // 设置选项的英文（中文），其中只有一个选项是对应正确的（由random2决定）
				test_time -= 1; // 每执行一次，计数器减一
				try {
					Thread.sleep(5000); // 设置线程睡眠时间为5秒，做到每隔五秒刷新单词
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				left_to_done.setText("剩余：" + test_time);
				right_done.setText("正确：" + right); // 不断显示剩余题数和正确题数（right的判定在下面的程序）
			}
			finalText.setText("测试结束!!!"); // 测试完10次后程序结束
		}
	}
	giveWord words = new giveWord();
	class ButtonAction implements ActionListener{ // 为五个按钮加入监听（加入代码在下面）
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String answer = showText.getText();
			int index = -1;
			for(int i = 0; i < 10; i++){
				if(Chinese_words[i].equals(answer)){
					index = i;
					break;
				}
			} // index用于获得显示的中文（英文）的下标，通过下标寻找对应的英文（中文），预存在中英文数组里的答案是一一对应的
			true_answer = English_words[index]; // true_answer是正确选项
			String my_answer = null;
			String ss = inputField.getText();	
			if(!ss.equals("")){ // 如果有输入
				if(ss.equals("A"))             //提交答案有两种方式，一种是输入，然后点击确定，在点击确定时会判定输
					my_answer = word[0];       //入对应的选项内容是否正确；另一种是直接点击选项按钮，获取按钮的值，
				else if(ss.equals("B"))        //再判断是否正确
					my_answer = word[1];
				else if(ss.equals("C"))
					my_answer = word[2];
				else if(ss.equals("D"))
					my_answer = word[3]; // 获得输入选项的答案
			}		
			else{				// 如果没有输入，获得被点击按钮的值
				my_answer = ((JButton)(e.getSource())).getText();
			}
			// true_or_false用于提示选中的单词或者填写的答案正确与否
			if(true_answer.equals(my_answer)){ // 如果答案相同正确
				true_or_false.setText("正确");
				right++; // 提示正确并且正确数加一
			}
			else{
				true_or_false.setText("错误"); // 其他情况均为错误
			}
			try {
				words.interrupt();
			} catch (Exception e2) {
				// TODO: handle exception
			}			
		}
	}
	
	@Override
	public void run() { // 重载主窗体的run方法，在这里实现组件添加，中英文切换
		// TODO Auto-generated method stub
		
		toEnglish = new JButton("中译英");
		toChinese = new JButton("英译中"); // 给两个模式的按钮
		toEnglish.setBounds(0, 0, 100, 50);
		toEnglish.setFont(new Font("TimesRoman",Font.BOLD,20));
		toEnglish.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) { // 中译英被点击，则选项是英文单词
				// TODO Auto-generated method stub
				String[] words1 = {"oblige","compassion","vicinity","trample","vacant","qualification","verge","submarine","segmentation","refine"};
				String[] words2 = {"迫使","同情心","附近","践踏","空的","资格","边缘","潜艇","分割","精炼"};
				System.arraycopy(words1, 0, English_words, 0, words1.length);
				System.arraycopy(words2, 0, Chinese_words, 0, words2.length); // 使用了arraycopy进行替换
				try {
					words.interrupt();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		toChinese.setBounds(0, 60, 100, 50);
		toChinese.setFont(new Font("TimesRoman",Font.BOLD,20));
		toChinese.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) { // 英译中被点击，则选项是中文
				// TODO Auto-generated method stub
				String[] words1 = {"oblige","compassion","vicinity","trample","vacant","qualification","verge","submarine","segmentation","refine"};
				String[] words2 = {"迫使","同情心","附近","践踏","空的","资格","边缘","潜艇","分割","精炼"};
				System.arraycopy(words2, 0, English_words, 0, words2.length);
				System.arraycopy(words1, 0, Chinese_words, 0, words1.length);
				try {
					words.interrupt();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		add(toEnglish);
		add(toChinese); // 添加组件
		
		showText = new JLabel(); // showText显示要翻译的单词（汉语）
		true_or_false = new JLabel(); // 正确与否的提示
		finalText = new JLabel(); // 测试结束的提示
		left_to_done = new JLabel("剩余：" + String.valueOf(test_time)); // 剩余题
		right_done = new JLabel("正确：" + String.valueOf(right)); // 正确题
		A = new JLabel("A、");
		B = new JLabel("B、");
		C = new JLabel("C、");
		D = new JLabel("D、");	// 添加四个A、B、C、D的label
		showText.setBounds(410, 120, 250, 50); // 以下是为所有的JLabel，JButton设置显示位置，大小，字体，并添加组件
		showText.setFont(new Font("TimesRoman",Font.BOLD,32));
		add(showText);
		true_or_false.setBounds(410, 500, 180, 50);
		true_or_false.setFont(new Font("TimesRoman",Font.BOLD,24));
		add(true_or_false);
		finalText.setBounds(320, 620, 180, 50);
		finalText.setFont(new Font("TimesRoman",Font.BOLD,32));
		add(finalText);
		left_to_done.setBounds(650, 10, 100, 50);
		left_to_done.setFont(new Font("TimesRoman",Font.BOLD,22));
		add(left_to_done);
		right_done.setBounds(650, 60, 100, 50);
		right_done.setFont(new Font("TimesRoman",Font.BOLD,22));
		add(right_done);
		A.setBounds(250, 200, 50, 50);
		A.setFont(new Font("TimesRoman",Font.BOLD,24));
		add(A);
		B.setBounds(250, 280, 50, 50);
		B.setFont(new Font("TimesRoman",Font.BOLD,24));
		add(B);
		C.setBounds(250, 360, 50, 50);
		C.setFont(new Font("TimesRoman",Font.BOLD,24));
		add(C);
		
		
		btnA = new JButton();
		btnB = new JButton();
		btnC = new JButton();
		btnD = new JButton();
		btnA.setBounds(320, 200, 250, 50);
		btnA.setFont(new Font("TimesRoman",Font.BOLD,20));
		btnA.addActionListener(new ButtonAction());
		add(btnA);
		btnB.setBounds(320, 280, 250, 50);
		btnB.setFont(new Font("TimesRoman",Font.BOLD,20));
		btnB.addActionListener(new ButtonAction());
		add(btnB);
		btnC.setBounds(320, 360, 250, 50);
		btnC.setFont(new Font("TimesRoman",Font.BOLD,20));
		btnC.addActionListener(new ButtonAction());
		add(btnC);
		btnD.setBounds(320, 440, 250, 50);
		btnD.setFont(new Font("TimesRoman",Font.BOLD,20));
		btnD.addActionListener(new ButtonAction());
		add(btnD);
		
		inputField = new JTextField();
		inputField.setBounds(250, 550, 200, 50);
		inputField.setText(null);
		inputField.setFont(new Font("TimesRoman",Font.BOLD,20));
		add(inputField);
		
		comfirm = new JButton("确认");
		comfirm.setBounds(470, 550, 100, 50);
		comfirm.setFont(new Font("TimesRoman",Font.BOLD,20));
		comfirm.addActionListener(new ButtonAction());
		add(comfirm);
		
		words.start();	// 在窗体中创建并启动子线程
		
		setLayout(null); // 设置布局，位置，大小，标题，设置可见，确保组件有效和点击关闭时的操作
		setBounds(600, 200, 800, 800);
		setTitle("test words");
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}


public class TranslateGui {
	public static void main(String[] args) {
		MainFrame myframe = new MainFrame();
		Thread MainThread = new Thread(myframe);
		MainThread.setName("主线程");
		MainThread.start(); // 在主线程中创建窗口
	}
}
