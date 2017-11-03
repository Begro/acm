package liu.yan.pattern.singleton;

/**
 * 静态内部类单例
 * 利用的是classloader的加载类的特性，保证唯一
 * 并且只有在使用时才会加载
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
