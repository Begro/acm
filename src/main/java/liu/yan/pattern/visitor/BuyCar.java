package liu.yan.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘研
 * @create 2017-11-22 16:30
 **/
public class BuyCar implements Product {

  private List<Product> products = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  @Override
  public void accept(Visitor visitor) {
    products.forEach(e -> e.accept(visitor));
  }

  @Override
  public void dosomething() {
    products.forEach(e->e.dosomething());
  }
}
