package liu.yan.pattern.chainofresponsibility;

/**
 * 第二个处理类
 *
 * @author 刘研
 * @create 2017-11-17 14:53
 **/
public class SecondHandler extends AbstractHandler{

  @Override
  void handle() {
    System.out.println("我最终处理");
  }

  @Override
  boolean enable() {
    return false;
  }
}
