package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * @create 2017-11-22 16:35
 **/
public class Customer {

  public static void main(String[] args) {
    BuyCar buyCar = new BuyCar();
    buyCar.add(new Apple());
    buyCar.add(new Book());
    buyCar.accept(new CustomerVisitor());
    buyCar.accept(new SalerVisitor());
  }
}
