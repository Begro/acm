package liu.yan.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

class FooBar {
	private int n;

	private AtomicBoolean isFoo = new AtomicBoolean(true);

	private static Object o = new Object();

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (o) {
				while (!isFoo.compareAndSet(true, false)) {
					o.wait();
				}
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				o.notifyAll();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (o) {
				while (!isFoo.compareAndSet(false, true)) {
					o.wait();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				o.notifyAll();
			}
		}
	}
}