package liu.yan.jvm;

/**
 * @author 刘研
 * @create 2017-11-22 21:09
 **/
public class StaticTest {

  static {
    i = 0;
//    System.out.println(i); //illegal forward reference
  }

  private static int i;

  public static void main(String[] args) {
    Runnable script = () -> {
      System.out.println(Thread.currentThread() + "start");
      DeapLoopClass deapLoopClass = new DeapLoopClass();
      System.out.println(Thread.currentThread() + "end");
    };
    Thread thread1 = new Thread(script);
    Thread thread2 = new Thread(script);
    thread1.start();
    thread2.start();

  }
}
