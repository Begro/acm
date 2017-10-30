package liu.yan.acm.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类 由于静态代理，只能代理一个具体类，如果每个类都需要增加相同功能，就需要为每个类增加一个代理类。 并且静态代理与被代理类实现统一接口，所以无论被代理类的方法是否需要增强，都需要重写其方法。
 *
 * @author 刘研
 * @create 2017-10-30 13:48
 **/
public class DynamicProxy implements InvocationHandler {

  private Object target;

  public DynamicProxy() {
  }

  public Object bind(Object target) {
    this.target = target;
    return Proxy
        .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before();
    Object result = method.invoke(target, args);
    after();
    return result;
  }

  private void before() {
    System.out.println("before......");
  }

  private void after() {
    System.out.println("after......");
  }
}
