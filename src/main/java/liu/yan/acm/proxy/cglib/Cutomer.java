package liu.yan.acm.proxy.cglib;

import liu.yan.acm.proxy.RealSubject;
import liu.yan.acm.proxy.Subject;

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
