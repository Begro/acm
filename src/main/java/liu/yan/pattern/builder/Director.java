package liu.yan.pattern.builder;

/**
 * 指挥类
 *
 * @author 刘研
 * @create 2017-10-25 10:30
 **/
public class Director {

  private AbstractBuilder abstractBuilder;

  public Director(AbstractBuilder builder) {
    this.abstractBuilder = builder;
  }

  public Product construct() {
    abstractBuilder.buildA();
    abstractBuilder.buildB();
    return abstractBuilder.getResult();
  }
}
