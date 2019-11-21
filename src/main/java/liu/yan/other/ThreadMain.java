package liu.yan.other;

import java.util.Random;

/**
 * @author liu yan
 * @description
 * @date 2019/2/26
 */
public class ThreadMain {
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			ThreadTest threadTest = new ThreadTest();
			threadTest.runMaster();
			try {
				Thread.sleep(random.nextInt(1000));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			threadTest.stopMaster();
		}
		System.out.println("game over");
		System.exit(0);
	}
}
