package liu.yan.acm.singleton;

/**
 * 双重检查锁单例
 * 单例要求系统中只有一个实例，并且自己可以对外提供这个实例
 * 一般有三点：1.私有构造函数
 *            2.私有的成员变量
 *            3.共有获取实例的方法
 * @author 刘研
 * @create 2017-10-24 16:25
 **/
public class Singleton1 {

  private static volatile Singleton1 singleton1 = null;

  private Singleton1() {
  }

  public static Singleton1 createInstance() {
    if (singleton1 == null) {
      synchronized (singleton1) {
        if (singleton1 == null) {
          singleton1 = new Singleton1();
        }
      }
    }
    return singleton1;
  }
}
