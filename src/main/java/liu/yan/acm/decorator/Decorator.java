package liu.yan.acm.decorator;

/**
 * 装饰者类:动态的为原对象增加新功能
 * 角色：接口，具体对象，抽象装饰者，装饰者
 * 优点：1.通过关联，动态的增加功能，相比于继承更加灵活
 *      2.可以使用不同的装饰类组合出更多的功能
 *      3.具体类与装饰类可以独立变化
 * 缺点：1.产生过多对象
 *      2.多次装饰的类，不容易排查错误
 * JDK:IO是装饰者模式.InputStream是接口，FileInputStream、ByteArrayInputStream具体类
 *      FilterInputStream抽象装饰者
        BufferedInputStream具体装饰者
 *
 *
 * @author 刘研
 * @create 2017-10-30 9:34
 **/
public class Decorator extends AbstractDecorator {

  @Override
  public void method() {
    System.out.println("装饰一下");
    super.method();
    System.out.println("装饰结束");
  }
}
