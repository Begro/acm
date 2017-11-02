package liu.yan.acm.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：将部分与整体统一化处理，尤其是处理树形结构时，比较方便
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
