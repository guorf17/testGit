package demo1;

import java.awt.*;

import javax.swing.*;
 
 
public class Test extends JFrame
{
	//����һ������
	Container ct;
	//����������塣
	BackgroundPanel bgp;
	
	//����һ����ť������֤�����ǵ�ȷ�Ǵ����˱���ͼƬ��������һ��ͼƬ��
	JButton jb;
	public static void main(String[] args)
	{
		new Test();
	}
	public Test()
	{
		//�������κβ��ַ�ʽ��
		ct=this.getContentPane();
		this.setLayout(null);
		
		//�����������һ��400*300����Ƭ�ȿ��Կ������Խ����
		bgp=new BackgroundPanel((new ImageIcon("/images/zhanchang2.png")).getImage());
		bgp.setBounds(0,0,1367,854);
		ct.add(bgp);
		
		//������ť
		jb=new JButton("���԰�ť");
		jb.setBounds(60,30,1367,854);
		ct.add(jb);
		
		this.setSize(367,854);
		this.setLocation(367,854);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
class BackgroundPanel extends JPanel
{
	Image im;
	public BackgroundPanel(Image im)
	{
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		
	}
}

