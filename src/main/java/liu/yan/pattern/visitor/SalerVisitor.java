package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * @create 2017-11-22 16:34
 **/
public class SalerVisitor implements Visitor{

  @Override
  public void visitApple(Apple apple) {
    System.out.println("扫码收钱");
  }

  @Override
  public void visitBook(Book book) {
    System.out.println("扫码收钱");
  }
}
