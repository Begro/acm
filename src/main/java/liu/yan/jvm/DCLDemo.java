package liu.yan.jvm;

/**
 * @author liuyan
 * @date 19:44 2020/4/4
 * @description
 */
public class DCLDemo {
	private int num;
	private volatile static DCLDemo demo;

	private DCLDemo() {
		this.num = 10;
	}

	public static DCLDemo getInstance() {
		if (demo == null) {
			synchronized (DCLDemo.class) {
				if (demo == null) {
					demo = new DCLDemo();
				}
			}
		}
		return demo;
	}

	public int getNum() {
		return num;
	}
	private void test() {
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}
	}
}
