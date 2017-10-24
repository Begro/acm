package liu.yan.acm.singleton;

/**
 * 内部类单例
 *
 * @author 刘研
 * @create 2017-10-24 16:30
 **/
public class Singleton2 {

  private Singleton2() {
  }

  private static class InnerClass {

    private static Singleton2 singleton2 = new Singleton2();
  }

  public static Singleton2 getInstance() {
    return InnerClass.singleton2;
  }
}
