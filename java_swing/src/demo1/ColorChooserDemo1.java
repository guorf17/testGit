package demo1;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
public class ColorChooserDemo1 extends MouseAdapter {  
      
    JFrame f = null;  
    JLabel label = null;  
    JLabel label1 = null;  
    JLabel label2 = null;  
    Rectangle rec1 = null;  
    Rectangle rec2 = null;  
  
    public ColorChooserDemo1() {  
      
        f = new JFrame("ColorChooser Example");  
        Container contentPane = f.getContentPane();  
        contentPane.addMouseListener(this);  
  
        label = new JLabel(" ", JLabel.CENTER);  
        label.setPreferredSize(new Dimension(300, 20));  
  
        JPanel panel = new JPanel();  
        panel.setLayout(new GridLayout(1, 2));  
  
        label1 = new JLabel("��Label", JLabel.CENTER);  
        label1.setBackground(Color.red);  
        label1.setForeground(Color.black);  
        label1.setOpaque(true);  
        label1.setBounds(0, 0, 150, 150);  
        panel.add(label1);  
  
        label2 = new JLabel("��Label", JLabel.CENTER);  
        label2.setBackground(Color.green);  
        label2.setForeground(Color.black);  
        label2.setOpaque(true);  
        label2.setBounds(150, 0, 150, 150);  
        panel.add(label2);  
  
        rec1 = label1.getBounds();  
        rec2 = label2.getBounds();  
  
        contentPane.add(panel, BorderLayout.CENTER);  
        contentPane.add(label, BorderLayout.SOUTH);  
  
        f.setSize(new Dimension(300, 150));  
        f.setVisible(true);  
  
        f.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
    }  
  
    // ʵ��MouseAdapter�е�mousePressed()��mouseClicked()����.���������ʱ,����֪�������Ŀǰ��λ��.�������������  
    // ����ʱ,���������λ����label��,�ͻ������ɫѡ��Ի���,�û���ѡ����һ��ɫ����label����ɫ.  
    public void mousePressed(MouseEvent e) {  
        label.setText("Ŀǰ������꣨X,Y��Ϊ����" + e.getX() + "," + e.getY() + ")");  
    }  
  
    public void mouseClicked(MouseEvent e) {  
        Point point = e.getPoint();  
  
        if (e.getClickCount() == 2) {  
            if (rec1.contains(point)) {  
                /* 
                 * ����JColorChooser��showDialog()��̬���������ɫѡ��Ի��� 
                 * ,showDialog()�е�3������������: �Ի���ĸ����,��ɫѡ��Ի������ 
                 * ,��Ի���Ĭ����ɫ.���û�ѡ������ɫ֮��,����"OK"��ť�򷵻� 
                 * Color����,������"Cancel"��ť�򷵻�nullֵ. 
                 */  
                Color color = JColorChooser.showDialog(f,  
                        "Change label1 Color", Color.white);  
                if (color != null) // ��Ϊnullֵ��ʾ�û�����Cancel��ť  
                    label1.setBackground(color);  
            }  
            if (rec2.contains(point)) {  
                Color color = JColorChooser.showDialog(f,  
                        "Change label2 Color", Color.yellow);  
                if (color != null) // ��Ϊnullֵ��ʾ�û�����Cancel��ť  
                    label2.setBackground(color);  
            }  
        }  
    }  
      
    public static void main(String[] arg) {  
        new ColorChooserDemo1();  
    }  
}