package wangZhe;

public class caoZuo implements Runnable, Map, heroList {
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
