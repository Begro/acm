package liu.yan.acm.decorator;

/**
 * 另外一个装饰者
 *
 * @author 刘研
 * @create 2017-10-30 9:54
 **/
public class Decorator2 extends AbstractDecorator {

  @Override
  public void method() {
    System.out.println("另外一个装饰");
    super.method();
    System.out.println("另外一个装饰结束");
  }
}
