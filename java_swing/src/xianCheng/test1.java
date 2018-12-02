package xianCheng;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 主类main
 * @author grf
 * @ClassName: ${test1---grf}
 */
public class test1 {
	/**
	 * 设置线程，分三路执行
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setXY task1 = new setXY();
		displayMap task2 = new displayMap();
		autoRobot task3 = new autoRobot();

		Thread t1 = new Thread(task1, "thread-1-setXY");
		Thread t2 = new Thread(task2, "thread-2-displayMap");
		Thread t3 = new Thread(task3, "thread-3-autoRobot");
		t1.start();
		t2.start();
		t3.start();

	}

}

class autoRobot implements Runnable, Map, heroList {
	/**
	 * 智能机器人类线程
	 * @ClassName: ${autoRobot}
	 */
	protected int a = 1, b = 2;

	@Override
	public void run() {

		synchronized (this) {
			Thread t = Thread.currentThread();
			// TODO Auto-generated method stub
			while (health[0] == "1") {
				System.out.println(t.getName() + " a=" + a + " b=" + b);
				System.out.println("hero:" + hero[10 - a] + ": health:" + (b + 10));

//				lock.lock();

				setMap(a, b);
				a += 1;
				b += 1;

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
//				finally {
//					lock.unlock();
//				}
			}
			System.out.println(t.getName() + "-finished");
		}
	}

	public void setMap(int a, int b) {
		map[a][b] = "$";
	}

}

class setXY implements Runnable, Map, heroList {
	/**
	 * 操作类线程
	 * @ClassName: ${setXY}
	 */
	protected int a = 1, b = 1;

	@Override
	public void run() {

		synchronized (this) {
			Thread t = Thread.currentThread();
			// TODO Auto-generated method stub
			while (a < 3) {
				System.out.println(t.getName() + " a=" + a + " b=" + b);
				System.out.println("hero:" + hero[a] + ": health:" + (b + 10));
//				lock.lock();

				setMap(a, b);
				a += 1;
				b += 1;

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
//				finally {
//					lock.unlock();
//				}
			}
			System.out.println(t.getName() + "-finished");
			health[0] = "0";
		}

	}

	public void setMap(int a, int b) {
		map[a][b] = "*";
	}

}
/**
 * 地图刷新类线程
 * @ClassName: ${displayMap}
 */
class displayMap implements Runnable, Map, heroList {
	protected int num;

	@Override
	public void run() {

		synchronized (this) {
			Thread t = Thread.currentThread();
			// TODO Auto-generated method stub

			while (health[0] == "1") {
				System.out.println(t.getName() + "--start");
				display();

				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
				}
			}
			System.out.println(t.getName() + "-finished");
		}

	}

	public void display() {
		int i, j;
		for (i = 0; i < 14; i++) {
			for (j = 0; j < 15; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}

	}
}
/*
 * 备选表情 ★☆✪☺◎☹☆▒▦▩↖↑↗→↘↓↙←♔♚۩➹❶❷❸❹❺❻❼❽❾❿ •▪♠♒†✖◎♣♦♥♠☀◐◑ ①②③④⑤⑥⑦⑧⑨⑩
 */
/**
 * 地图接口Map
 */
interface Map {
//	Lock lock = new ReentrantLock();
	/**
	 * 设置地图基础背景
	 * <p>英雄符号①②③④⑤代表蓝方英雄
	 * <p>英雄符号❻❼❽❾❿代表红方英雄
	 * <p>符号♥代表各自方的水晶
	 * <p>符号♣代表森林障碍
	 */
	String map[][] = { 
			{ " ", " ", " ", " ", " ", " ", " ", " ", "①", "②", "③", "④", "⑤", " ", " " },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "♥", "†" },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ "†", "•", "♣", "♣", "♣", "•", "•", "•", "•", "•", "♣", "♣", "♣", "•", "†" },
			{ "†", "•", "♣", "♣", "♣", "•", "•", "•", "•", "•", "♣", "♣", "♣", "•", "†" },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ "†", "•", "♣", "♣", "♣", "•", "•", "•", "•", "•", "♣", "♣", "♣", "•", "†" },
			{ "†", "•", "♣", "♣", "♣", "•", "•", "•", "•", "•", "♣", "♣", "♣", "•", "†" },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ "†", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ "†", "♥", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "•", "†" },
			{ " ", " ", "❻", "❼", "❽", "❾", "❿", " ", " ", " ", " ", " ", " ", " ", " " }, };
	/**
	 * 设置水晶是否打破
	 */
	String health[] = { "1" };
}
/**
 * 设置英雄列表接口
 * <p>英雄符号①②③④⑤代表蓝方英雄
 * <p>英雄符号❻❼❽❾❿代表红方英雄
 */
interface heroList {
	String hero[] = { "①", "②", "③", "④", "⑤", "❻", "❼", "❽", "❾", "❿" };
}