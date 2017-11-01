package liu.yan.acm.bridge;

/**
 * 桥接:为了简化一个系统有多个维度的变化
 * 例如笔，要求有不同的字体和颜色两个维度的变化，例如n种字体，m种颜色，如果用继承需要m*n个类。
 * 用桥接模式，定义n个字体，m个颜色，只需要m+n个类，并且可以独立变化
 *
 * @author 刘研
 * @create 2017-11-01 14:13
 **/
public class Bridge extends AbstractBridge {

  @Override
  void doit() {
    System.out.println("123");
    super.getSource().method();
    System.out.println("321");
  }
}
