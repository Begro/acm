package liu.yan.pattern.decorator;

/**
 * 客户端
 *
 * @author 刘研
 * @create 2017-10-30 9:39
 **/
public class Customer {

  public static void main(String[] args){
    AbstractDecorator decorator = new Decorator();
    decorator.setSources(new Sources());
//    decorator.method();
    AbstractDecorator decorator1  = new Decorator2();
    decorator1.setSources(decorator);
    decorator1.method();
  }
}
