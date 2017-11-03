package liu.yan.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出测试 -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author 刘研
 * @create 2017-11-02 21:58
 **/
public class HeapOOM {

  static class OOMObject {

  }

  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<>();
    while (true) {
      list.add(new OOMObject());
    }
  }
}
