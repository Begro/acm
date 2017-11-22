package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * @create 2017-11-22 16:29
 **/
public class Book implements Product {

  @Override
  public void accept(Visitor visitor) {
    visitor.visitBook(this);
  }

  @Override
  public void dosomething() {
    System.out.println("我是树");
  }
}
