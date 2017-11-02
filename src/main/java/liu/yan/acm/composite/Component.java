package liu.yan.acm.composite;

/**
 * 抽象组件
 *
 * @author 刘研
 * @create 2017-11-02 13:50
 **/
public abstract class Component {

  abstract void add(Component component);

  abstract void list();

  abstract void method();
}
