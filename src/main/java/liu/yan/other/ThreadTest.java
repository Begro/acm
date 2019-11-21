package liu.yan.other;

import java.util.Random;

/**
 * @author liu yan
 * @description
 * @date 2019/2/26
 */
public class ThreadTest extends Thread {
	private boolean isEnd;
	private boolean isStarted;

	public ThreadTest() {
		this.isEnd = false;
		this.isStarted = false;
	}

	public void runMaster() {
		start();
	}

	public void stopMaster() {
		if (isStarted) {
			isEnd = true;
			try {
				System.out.println("join");
				this.join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		this.isStarted = true;
		Random random = new Random();
		while (true) {
			if (isEnd) {
				System.out.println("结束.......");
				return;
			}
			try {
				Thread.sleep(random.nextInt(500));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
