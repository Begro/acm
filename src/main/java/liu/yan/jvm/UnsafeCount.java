package liu.yan.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyan
 * @date 14:33 2020/5/2
 * @description
 */
public class UnsafeCount {
	private AtomicInteger value = new AtomicInteger();

	private AtomicInteger key = new AtomicInteger();

	public synchronized int getNext() {
		return value.getAndIncrement() + key.getAndIncrement();
	}
}
