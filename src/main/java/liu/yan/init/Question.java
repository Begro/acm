package liu.yan.init;

/**
 * @author liuyan
 * @date 22:27 2019/9/3
 * @description
 */
public class Question {
//	static {
//		init();
//	}
	private static Object a = new Object();
	private static void init() {
		System.out.println(a != null);
	}
	public static void test1(){
		System.out.println(a != null);
	}
	public void test2(){
		System.out.println(a != null);
	}
}
