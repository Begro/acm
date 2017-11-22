package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * @create 2017-11-22 16:28
 **/
public class Apple implements Product {

  @Override
  public void accept(Visitor visitor) {
    visitor.visitApple(this);
  }

  @Override
  public void dosomething() {
    System.out.println("我是苹果");
  }
}
