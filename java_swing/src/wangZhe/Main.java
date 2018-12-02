package wangZhe;
import java.util.*;

public class Main {
	public class test1 {
		/**
		 * 设置线程，分三路执行
		 * @param args
		 */
		public void main(String[] args) {
			// TODO Auto-generated method stub
			caoZuo task1 = new caoZuo();
			displayMap task2 = new displayMap();
			autoRobot task3 = new autoRobot();

			Thread t1 = new Thread(task1, "thread-1-caoZuo");
			Thread t2 = new Thread(task2, "thread-2-displayMap");
			Thread t3 = new Thread(task3, "thread-3-autoRobot");
			t1.start();
			t2.start();
			t3.start();

		}

	}
}
