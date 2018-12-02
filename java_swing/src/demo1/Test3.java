package demo1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextArea;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Test3 extends JFrame implements ActionListener{
	
	//容器窗口  (相当于一个桌子)
private JFrame frame;
private JButton  jbn1=new JButton("随机下一张");
private JButton  jbn2=new JButton("随机上一张");
//附属容器  (相当于桌子上的桌布)
private Container container=null;
private JLabel jlabel=null;
private JLabel jlabe2=null;
private JLabel jlabe3=null;
	public static void main(String[] args) {
		Test3 test3=new Test3();
				
	}
	public  Test3(){
		//设置窗口的标题
		frame = new JFrame("变换图片");
		this.setTitle("变换图片");
		//获得容器中的附属容器
	
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		int i=(int)(Math.random()*10);
		
		jlabel=new JLabel(new ImageIcon("images/"+i+".jpg"));
		container.add(jlabel);
		container.add(jbn1,BorderLayout.SOUTH);
		container.add(jbn2,BorderLayout.NORTH);
		//创建监听器
		jbn1.setActionCommand("下一张");
		jbn2.setActionCommand("上一张");
		jbn1.addActionListener(this);
		jbn2.addActionListener(this);
		
		this.setLocation(150,0);
		this.setSize(1024,668);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			if(e.getActionCommand().equals("上一张")){
				jlabel.setVisible(false);
				int m=(int)(Math.random()*10);
				jlabel=new JLabel(new ImageIcon("images/"+m+".jpg"));
				container.add(jlabel);
				jlabel.setVisible(true);
				System.out.println("您点击了上一张"+"m="+m);
				
			}
			if(e.getActionCommand().equals("下一张")){
				jlabel.setVisible(false);
				int n=(int)(Math.random()*10);
				
				jlabel=new JLabel(new ImageIcon("images/"+n+".jpg"));
				container.add(jlabel);
				jlabel.setVisible(true);
				System.out.println("您点击了上一张"+"n="+n);
			}		
	}
 
}
