package demo1;

/**
 * ��JFrame ���һ������ͼ����
 */
import javax.swing.*;
 
public class JFrameBackground4 extends JFrame
{
	//����һ��JLayeredPane���ڷֲ�ġ�
	JLayeredPane layeredPane;
	//����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������
	JPanel jp;
	JLabel jl;
	ImageIcon image;
	
	//����һ����ť���ڲ��Եġ�
	JButton jb;
	public static void main(String[] args)
	{
		new JFrameBackground4();
	}
	
	public JFrameBackground4()
	{
		layeredPane=new JLayeredPane();
		//image=new ImageIcon("/images/zhanchang.jpg");//�����һ��ͼ�Ϳ��Կ���Ч����	
		ImageIcon image = new ImageIcon(this.getClass().getResource(
	            "/images/zhanchang2.png"));
		//������������Щ����
		jp=new JPanel();
		jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
 
		jl=new JLabel(image);
//		jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
		jp.add(jl);
		
		//����һ�����԰�ť
		jb=new JButton("���԰�ť");
		jb.setBounds(100,100,100,100);
		
		//��jp�ŵ���ײ㡣
		layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
		//��jb�ŵ���һ��ĵط�
		layeredPane.add(jb,JLayeredPane.MODAL_LAYER);
		
		this.setLayeredPane(layeredPane);
		this.setSize(image.getIconWidth(),image.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(image.getIconWidth(),image.getIconHeight());
		this.setVisible(true);	
	}
}

