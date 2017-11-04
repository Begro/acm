package liu.yan.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量池的溢出
 * 使用String.intern()可以把一个字符串放到常量区
 * jdk8之后，常量区已经移到了堆中，本机是jdk8,只能看到heap space溢出，看不到permGen space溢出了
 * 本来书中的参数是：-XX:PermSize=10M -XXMaxPermSize=10M 已经不起作用了，做提示参数废弃了
 * 所以这里设置堆大小就可以看到溢出结果：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 * @author 刘研
 * @create 2017-11-04 16:17
 **/
public class RuntimeConstantPoolOOM {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    int i =0;
    while(true){
      list.add(String.valueOf(i++).intern());
    }
  }
}
