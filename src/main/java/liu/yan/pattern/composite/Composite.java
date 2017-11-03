package liu.yan.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：将部分与整体统一化处理，尤其是处理树形结构时，比较方便
 * 优点：1.可以清楚地轻易分层次的对象，类似于文件结构
 *      2.客户端可以一致的使用组合结构或者其中单个对象
 *      3.更容易在组合体内增加单个对象
 * 缺点：1.设计更加抽象
 * 使用场景：对部分和整体统一化处理，对象的结构比较复杂
 * @author 刘研
 * @create 2017-11-02 13:52
 **/
public class Composite extends Component {

  private List<Component> componentList = new ArrayList<>();

  @Override
  void add(Component component) {
    componentList.add(component);
  }


  @Override
  void list() {
    for (Component component : componentList) {
      System.out.println(component);
    }
  }

  @Override
  void method() {
    for (Component component : componentList) {
      component.method();
    }
  }
}
