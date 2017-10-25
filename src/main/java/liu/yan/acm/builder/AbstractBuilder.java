package liu.yan.acm.builder;

/**
 * 抽象建造类
 *
 * @author 刘研
 * @create 2017-10-25 10:29
 **/
public abstract class AbstractBuilder {

  protected Product product = new Product();

  abstract void buildA();

  abstract void buildB();

  public Product getResult() {
    return product;
  }
}
