package liu.yan.acm.composite;

/**
 * 客户端
 *
 * @author 刘研
 * @create 2017-11-02 13:56
 **/
public class Customer {

  public static void main(String[] args) {
    Component root = new Composite();
    Component composite = new Composite();
    Component leaf0 = new Leaf();
    Component leaf1 = new Leaf();
    Component leaf2 = new Leaf();

    composite.add(leaf0);
    composite.add(leaf1);
    composite.add(leaf2);

    root.add(composite);
    root.method();
  }
}
