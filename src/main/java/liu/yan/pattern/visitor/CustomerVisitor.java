package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * @create 2017-11-22 16:34
 **/
public class CustomerVisitor implements Visitor {

  @Override
  public void visitApple(Apple product) {
    product.dosomething();
    System.out.println("买苹果");
  }

  @Override
  public void visitBook(Book product) {
    product.dosomething();
    System.out.println("买书");
  }
}
