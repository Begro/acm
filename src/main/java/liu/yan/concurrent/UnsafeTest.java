package liu.yan.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author liu yan
 * @description
 * @date 2018/7/22
 */
public class UnsafeTest {
//	static final Unsafe unsafe = Unsafe.getUnsafe();
	static final Unsafe UNSAFE;
	static final long startOffset;
	private volatile  long state = 0;
	static {
		/*try {
			startOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("startOffset"));
		} catch(NoSuchFieldException e) {
			e.printStackTrace();
			throw new Error(e);
		}*/
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			 UNSAFE= (Unsafe) field.get(null);
			 startOffset = UNSAFE.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
		} catch(NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			throw new Error(e);
		}
	}
	
	public static void main(String[] args) {
		UnsafeTest unsafeTest = new UnsafeTest();
		boolean b = UNSAFE.compareAndSwapLong(unsafeTest, startOffset, 0, 1);
		System.out.println(b);
		
		try {
			Node node = new Node("1",1);
			
			Field port = Node.class.getDeclaredField("port");
			port.setAccessible(true);
			int anInt = port.getInt(node);
			System.out.println(anInt);
		} catch(NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
}
