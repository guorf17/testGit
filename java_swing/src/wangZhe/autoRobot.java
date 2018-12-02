package wangZhe;

public class autoRobot implements Runnable, Map, heroList {
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

//					lock.lock();

					setMap(a, b);
					a += 1;
					b += 1;

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
//					finally {
//						lock.unlock();
//					}
				}
				System.out.println(t.getName() + "-finished");
			}
		}

		public void setMap(int a, int b) {
			map[a][b] = "$";
		}

}
