package liu.yan.pattern.decorator;

/**
 * 具体的被装饰类
 *
 * @author 刘研
 * @create 2017-10-30 9:33
 **/
public class Sources implements ISources {

  @Override
  public void method() {
    System.out.println("原始类");
  }
}
