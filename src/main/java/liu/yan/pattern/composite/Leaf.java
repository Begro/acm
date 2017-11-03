package liu.yan.pattern.composite;

/**
 * 叶子结点
 *
 * @author 刘研
 * @create 2017-11-02 13:51
 **/
public class Leaf extends Component {

  @Override
  void add(Component component) {

  }

  @Override
  void list() {

  }

  @Override
  void method() {
    System.out.println("执行叶子结点方法");
  }
}
