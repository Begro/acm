package liu.yan.acm.builder;

/**
 * 具体建造类
 *
 * @author 刘研
 * @create 2017-10-25 10:32
 **/
public class ConcreteBuilderA extends AbstractBuilder {

  @Override
  void buildA() {
    product.setPartA("A");
  }

  @Override
  void buildB() {
    product.setPartB("B");
  }
}
