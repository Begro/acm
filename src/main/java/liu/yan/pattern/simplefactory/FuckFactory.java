package liu.yan.pattern.simplefactory;

/**
 * 工厂类 根据类型创建不同的具体类,属于创建型模式
 * 包含三个角色：工厂类，抽象角色，具体角色
 * 优点：1.实现了对责任的分割，有专门的工厂用于创建对象
 *      2.客户端无需知道具体的类名，只需要知道对应的参数
 *      3.可以通过引入配置文件，可以在不修改代码的情况下更换产品类
 * 缺点：1.工厂类过于职责过重
 *      2.系统扩展困难，增加新角色，需要修改工厂类
 * 场景:类比较少；客户端不关心具体类，只关心参数
 * @see java.text.DateFormat
 *
 * @author 刘研
 * @create 2017-10-24 15:02
 **/
public class FuckFactory {

  public static IFuckCompany createFuck(String type) {
    if ("yht".equals(type)) {
      return new FuckYht();
    } else if ("piao".equals(type)) {
      return new FuckPiao();
    } else {
      throw new RuntimeException("error type");
    }
  }
}
