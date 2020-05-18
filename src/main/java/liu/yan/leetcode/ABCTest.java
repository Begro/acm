package liu.yan.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author liuyan
 * @date 15:15 2020/5/16
 * @description
 */
public class ABCTest {
	private static Semaphore semaphoreA = new Semaphore(1);
	private static Semaphore semaphoreB = new Semaphore(0);
	private static Semaphore semaphoreC = new Semaphore(0);

	public static void main(String[] args) {
		int target = 20;
		if (args.length == 1) {
			target = Integer.parseInt(args[0]);
		}
		int finalTarget = target;
		Thread threadA = new Thread(() -> {
			try {
				for (int i = 1; i <= finalTarget; i += 3) {
					semaphoreA.acquire();
					System.out.println(i);
					semaphoreB.release();
				}

			} catch (InterruptedException e) {
			}
		});
		Thread threadB = new Thread(
				() -> {
					try {
						for (int i = 2; i <= finalTarget; i += 3) {
							semaphoreB.acquire();
							System.out.println(i);
							semaphoreC.release();
						}
					} catch (InterruptedException e) {
					}
				}
		);
		Thread threadC = new Thread(() -> {
			try {
				for (int i = 3; i <= finalTarget; i += 3) {
					semaphoreC.acquire();
					System.out.println(i);
					semaphoreA.release();
				}
			} catch (InterruptedException e) {
			}
		});
		threadA.start();
		threadB.start();
		threadC.start();

	}
}
