package liu.yan.jvm;

/**
 * 内存分配测试
 *
 * @author 刘研
 * @create 2017-11-13 21:30
 **/
public class TestAllocation {

  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    testPresize();
  }
  public static void testAllocation() {
    byte[] a1, a2, a3, a4;
    a1 = new byte[_1MB];
    a2 = new byte[_1MB];
    a3 = new byte[_1MB];
    a4 = new byte[_1MB];
  }
  public static void testPresize(){
    byte[] bs = new byte[40*_1MB];
  }
}
