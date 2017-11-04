package liu.yan.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区溢出
 * jdk8中方法区已经被metaSpace取代，默认情况下metaspace大小是没有限制，
 * 需要使用-XX:MaxMetaspaceSize参数设置大小
 * @author 刘研
 * @create 2017-11-04 16:30
 **/
public class MethodAreaOOM {

  public static void main(String[] args) {
    while (true
        ) {
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(OOMObject.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(
          (MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
      enhancer
          .create();
    }
  }

   static class OOMObject {

  }
}
