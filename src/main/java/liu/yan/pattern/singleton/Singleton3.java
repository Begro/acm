package liu.yan.pattern.singleton;

/**
 * 枚举方式
 *
 * @author 刘研
 * @create 2017-10-24 16:36
 **/
public enum Singleton3 {
  instance;

  public void doSomething() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println(Thread.currentThread().getId());
  }
}
