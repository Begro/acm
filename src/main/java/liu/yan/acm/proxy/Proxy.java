package liu.yan.acm.proxy;

/**
 * 代理类
 * 代理模式与装饰者模式的区别：
 * 代理模式倾向于对对象访问的控制，装饰者模式倾向于动态为对象增加新方法。
 * 用代理模式，代理类对客户端隐藏了对象信息，因此在使用代理模式时，一般在代理类中就创建了对象的实例。
 * 装饰者模式，将待装饰类作为参数传递给装饰者的构造函数。类之间的关系由客户端指定。
 * 角色：抽象对象，具体对象，代理类
 *
 * @author 刘研
 * @create 2017-10-30 13:31
 **/
public class Proxy implements Subject {

  private Subject subject;

  public Proxy() {
    this.subject = new RealSubject();
  }


  @Override
  public void doSomething() {
    before();
    subject.doSomething();
    after();
  }

  private void before() {
    System.out.println("before......");
  }

  private void after() {
    System.out.println("after......");
  }
}
