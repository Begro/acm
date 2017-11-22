package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * @create 2017-11-22 16:28
 **/
public interface Product {

  void accept(Visitor visitor);

  void dosomething();
}
