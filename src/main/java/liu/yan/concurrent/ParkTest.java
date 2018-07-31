package liu.yan.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liu yan
 * @description
 * @date 2018/7/23
 */
public class ParkTest {
	/*public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("begin");
				LockSupport.park();
				System.out.println("end");
			}
		});
		thread.start();
		Thread.sleep(1000);
		System.out.println("unpark");
		LockSupport.unpark(thread);
	}*/
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("child thread begin park!");
				// 调用park方法，挂起自己,只有被中断才会退出循环
				while (!Thread.currentThread().isInterrupted()) {
					LockSupport.park();
				}
				System.out.println("child thread unpark!");
			}
		});
		thread.start();
		// 主线程休眠1S
		Thread.sleep(2000);
		System.out.println("main thread begin unpark!");
		// 中断子线程线程
		thread.interrupt();
	}
}
