package demo1;

/**
 * 给JFrame 添加一个背景图案。
 */
import javax.swing.*;
 
public class JFrameBackground4 extends JFrame
{
	//创建一个JLayeredPane用于分层的。
	JLayeredPane layeredPane;
	//创建一个Panel和一个Label用于存放图片，作为背景。
	JPanel jp;
	JLabel jl;
	ImageIcon image;
	
	//创建一个按钮用于测试的。
	JButton jb;
	public static void main(String[] args)
	{
		new JFrameBackground4();
	}
	
	public JFrameBackground4()
	{
		layeredPane=new JLayeredPane();
		//image=new ImageIcon("/images/zhanchang.jpg");//随便找一张图就可以看到效果。	
		ImageIcon image = new ImageIcon(this.getClass().getResource(
	            "/images/zhanchang2.png"));
		//创建背景的那些东西
		jp=new JPanel();
		jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
 
		jl=new JLabel(image);
//		jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
		jp.add(jl);
		
		//创建一个测试按钮
		jb=new JButton("测试按钮");
		jb.setBounds(100,100,100,100);
		
		//将jp放到最底层。
		layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
		//将jb放到高一层的地方
		layeredPane.add(jb,JLayeredPane.MODAL_LAYER);
		
		this.setLayeredPane(layeredPane);
		this.setSize(image.getIconWidth(),image.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(image.getIconWidth(),image.getIconHeight());
		this.setVisible(true);	
	}
}

