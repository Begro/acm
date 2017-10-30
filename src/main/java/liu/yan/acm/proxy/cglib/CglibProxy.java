package liu.yan.acm.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib方式的动态代理 jdk方式的动态代理，要求被代理类一定实现了某一接口，使用有一定的局限性 jdk方式使用的是反射机制，创建类效率较高。 cglib方式使用的是asm方式，效率较低。
 *
 * @author 刘研
 * @create 2017-10-30 14:16
 **/
public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class clazz) {
    //设置需要创建子类的类
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    //通过字节码技术动态创建子类实例
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    before();
    Object result = methodProxy.invokeSuper(o, args);
    after();
    return result;
  }

  private void after() {
    System.out.println("after......");
  }

  private void before() {
    System.out.println("before......");
  }
}
