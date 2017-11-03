package liu.yan.pattern.proxy;

/**
 * 具体被代理类
 *
 * @author 刘研
 * @create 2017-10-30 13:31
 **/
public class RealSubject implements Subject{

  @Override
  public void doSomething() {
    System.out.println("执行......");
  }
}
