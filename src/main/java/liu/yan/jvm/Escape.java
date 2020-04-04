package liu.yan.jvm;

import java.io.IOException;

/**
 * @author liuyan
 * @date 21:25 2020/4/2
 * @description
 */
public class Escape {
	private static int count = 1000000;

	public static void main(String[] args) throws InterruptedException, IOException {
		Escape escape = new Escape();
		for (int i = 0; i < count; i++) {
			escape.createDachou();
		}
		while (true) {
			Thread.sleep(10000);
		}
	}

	private void createDachou() {
		DaChou daChou = new DaChou("da", "chou");
	}

	static class DaChou {

		private String da;
		private String chou;

		public DaChou(String da, String chou) {
			this.da = da;
			this.chou = chou;
		}
	}
}
