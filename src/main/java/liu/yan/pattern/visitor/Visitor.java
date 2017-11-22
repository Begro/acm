package liu.yan.pattern.visitor;

/**
 * @author 刘研
 * 访问者模式：相同的元素对象，有多种不同的操作方式，操作方式会变化。封装一些施加于某种元素的操作，
 * 一旦这些操作需要修改的话，不需要修改原数据结构
 * 角色：抽象访问者，具体访问者，抽象元素，具体元素，数据结构
 *
 * @create 2017-11-22 16:25
 **/
public interface Visitor {

  void visitApple(Apple product);

  void visitBook(Book product);
}
