package liu.yan.pattern.proxy.cglib;

import liu.yan.pattern.proxy.RealSubject;
import liu.yan.pattern.proxy.Subject;

/**
 * @author 刘研
 * @create 2017-10-30 14:26
 **/
public class Cutomer {

  public static void main(String[] args) {
    CglibProxy cglibProxy = new CglibProxy();
    Subject subject = (Subject) cglibProxy.getProxy(RealSubject.class);
    subject.doSomething();
  }
}
