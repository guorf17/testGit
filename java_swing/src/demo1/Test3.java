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
	
	//��������  (�൱��һ������)
private JFrame frame;
private JButton  jbn1=new JButton("�����һ��");
private JButton  jbn2=new JButton("�����һ��");
//��������  (�൱�������ϵ�����)
private Container container=null;
private JLabel jlabel=null;
private JLabel jlabe2=null;
private JLabel jlabe3=null;
	public static void main(String[] args) {
		Test3 test3=new Test3();
				
	}
	public  Test3(){
		//���ô��ڵı���
		frame = new JFrame("�任ͼƬ");
		this.setTitle("�任ͼƬ");
		//��������еĸ�������
	
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		int i=(int)(Math.random()*10);
		
		jlabel=new JLabel(new ImageIcon("images/"+i+".jpg"));
		container.add(jlabel);
		container.add(jbn1,BorderLayout.SOUTH);
		container.add(jbn2,BorderLayout.NORTH);
		//����������
		jbn1.setActionCommand("��һ��");
		jbn2.setActionCommand("��һ��");
		jbn1.addActionListener(this);
		jbn2.addActionListener(this);
		
		this.setLocation(150,0);
		this.setSize(1024,668);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			if(e.getActionCommand().equals("��һ��")){
				jlabel.setVisible(false);
				int m=(int)(Math.random()*10);
				jlabel=new JLabel(new ImageIcon("images/"+m+".jpg"));
				container.add(jlabel);
				jlabel.setVisible(true);
				System.out.println("���������һ��"+"m="+m);
				
			}
			if(e.getActionCommand().equals("��һ��")){
				jlabel.setVisible(false);
				int n=(int)(Math.random()*10);
				
				jlabel=new JLabel(new ImageIcon("images/"+n+".jpg"));
				container.add(jlabel);
				jlabel.setVisible(true);
				System.out.println("���������һ��"+"n="+n);
			}		
	}
 
}
