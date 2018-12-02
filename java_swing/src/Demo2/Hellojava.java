package Demo2;

import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

public class Hellojava {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		// TODO Auto-generated method stub
		
		javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				creatAndShowGUI();
			}
		});		
	}
	
	private static void creatAndShowGUI() {
		JFrame win = new JFrame("HelloSwing 的标题");
		
		win.setSize(1500, 1000);
		win.setLocation(250,250);
		
		JLabel lable = new JLabel("这是一个Label!");
		
		win.add(lable);
		
		win.setDefaultCloseOperation(
	        JFrame.DISPOSE_ON_CLOSE);
		
		win.setVisible(true);
	}
	
}








