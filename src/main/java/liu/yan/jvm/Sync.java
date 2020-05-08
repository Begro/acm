package liu.yan.jvm;

/**
 * @author liuyan
 * @date 17:07 2020/5/2
 * @description
 */
public class Sync {

	public void test1() {
		synchronized (Sync.class) {
		}
	}

	public synchronized void test2(){

	}
}
