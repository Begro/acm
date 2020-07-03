package liu.yan.jvm;

import java.util.ArrayList;
import java.util.List;

public class GCTest {

	byte[] bytes = new byte[4096];

	public static void main(String[] args) {
		for (; ; ) {
			test();
		}
	}

	private static void test() {
		List<GCTest> aa = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			aa.add(new GCTest());
		}
	}
}