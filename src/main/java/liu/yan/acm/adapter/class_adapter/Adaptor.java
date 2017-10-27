package liu.yan.acm.adapter.class_adapter;

/**
 * 适配类,通过继承原有的类，将待适配的类的方法扩展到新的接口中
 * 角色：原有待适配类，需要适配的接口，适配器类
 * 通过继承原有的类，达到使原有类兼容新的接口
 * @author 刘研
 * @create 2017-10-27 10:19
 **/
public class Adaptor extends Source implements Target {

  @Override
  public void love() {
    System.out.println("Adaptor love");
  }
}
