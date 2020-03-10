package liu.yan.leetcode;

import java.util.concurrent.Semaphore;

class H2O {

	Semaphore h = new Semaphore(2);
	Semaphore o = new Semaphore(1);

	public H2O() {

	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		h.acquire();
		releaseHydrogen.run();
		o.release();
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		o.acquire(2);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		h.release(2);
	}
}