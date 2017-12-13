package liu.yan.jvm;

/**
 * @author 刘研
 * @create 2017-12-04 21:16
 **/
public class SlotGcTest {

  public static void main(String[] args) {
    {
      byte[] bs = new byte[64*1024*1024];
    }
    int a =1;
    System.gc();
  }
}
