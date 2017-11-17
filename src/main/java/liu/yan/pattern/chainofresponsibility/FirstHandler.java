package liu.yan.pattern.chainofresponsibility;

/**
 * 第一个处理类
 *
 * @author 刘研
 * @create 2017-11-17 14:52
 **/
public class FirstHandler extends AbstractHandler {

  @Override
  void handle() {
    if (enable()) {
      System.out.println("我自己处理了");
    } else {
      getHandler().handle();
    }
  }

  @Override
  boolean enable() {
    return false;
  }
}
