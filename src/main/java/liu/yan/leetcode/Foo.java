package liu.yan.leetcode;

import java.util.concurrent.CountDownLatch;

class Foo {
	CountDownLatch first;
	CountDownLatch second;

	public Foo() {
		first = new CountDownLatch(1);
		second = new CountDownLatch(1);
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		first.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		first.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		second.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		second.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}