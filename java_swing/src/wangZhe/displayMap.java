package wangZhe;

public class displayMap implements Runnable, Map, heroList {
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
