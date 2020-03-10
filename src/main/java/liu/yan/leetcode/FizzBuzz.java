package liu.yan.leetcode;

import java.util.function.IntConsumer;

class FizzBuzz {
	private int n;

	static volatile int flag = 0;

	public FizzBuzz(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 3; i <= n; i += 3) {
			if (i % 5 == 0) {
				continue;
			}
			while (flag!=3){
				Thread.sleep(1);
			}
			printFizz.run();
			flag=0;
		}

	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 5; i <= n; i += 5) {
			if (i % 3 == 0) {
				continue;
			}
			while (flag!=5){
				Thread.sleep(1);
			}
			printBuzz.run();
			flag=0;
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for (int i = 15; i <= n; i += 15) {
			while (flag!=15){
				Thread.sleep(1);
			}
			printFizzBuzz.run();
			flag=0;
		}

	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			while(flag!=0){
				Thread.sleep(1);
			}
			if (i % 3 != 0 && i % 5 != 0) {
				printNumber.accept(i);
			} else if (i % 3 == 0 && i % 5 != 0) {
				flag=3;
			} else if (i % 3 != 0 && i % 5 == 0) {
				flag=5;
			} else {
				flag=15;
			}
		}
	}
}