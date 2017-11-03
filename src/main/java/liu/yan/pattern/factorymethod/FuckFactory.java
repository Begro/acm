package liu.yan.pattern.factorymethod;

/**
 *因为简单工厂模式在传入参数错误时，会产生错误，这里将创建具体角色的方法分开
 *
 * @author 刘研
 * @create 2017-10-24 15:02
 * @see java.text.DateFormat
 **/
public class FuckFactory {

  public static IFuckCompany createFuckYht() {
    return new FuckYht();
  }

  public static IFuckCompany createFuckPiao() {
    return new FuckPiao();
  }
}
