package liu.yan.acm.proxy.dynamic;

import liu.yan.acm.proxy.RealSubject;
import liu.yan.acm.proxy.Subject;

/**
 * 客户端
 *
 * @author 刘研
 * @create 2017-10-30 15:42
 **/
public class Customer {

  public static void main(String[] args) {
    DynamicProxy proxy = new DynamicProxy();
    Subject subject = (Subject) proxy.bind(new RealSubject());
    subject.doSomething();
  }
}
