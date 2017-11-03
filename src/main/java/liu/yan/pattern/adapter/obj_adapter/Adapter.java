package liu.yan.pattern.adapter.obj_adapter;

/**
 * 适配类,通过持有待适配的类的对象，扩展其原有方法，得到兼容性
 * 优点：1.带适配类和目标接口解耦，通过引入适配类，不修改原有代码的情况下，重用原类的功能。
 *      2.增加类的透明性和复用性，具体实现在待适配类中，对客户端透明
 *      3.灵活和可扩展
 * 缺点：类的适配器模式：只能适配一个具体类
 *       对象适配器模式：很难替换待适配的类
 * 应用场景：spring的aop，Advice就是带是配的类，需要给适配成MethodInterceptor，通过的就是AdvisorAdapter做的适配
 * @author 刘研
 * @create 2017-10-27 10:22
 **/
public class Adapter implements Target {

  private Source source;

  public Adapter(Source source) {
    super();
    this.source = source;
  }

  @Override
  public void fuck() {
    source.fuck();
  }

  @Override
  public void love() {
    System.out.println("love");
  }
}
