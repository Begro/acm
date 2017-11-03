package liu.yan.pattern.bridge;

/**
 * 具体类
 *
 * @author 刘研
 * @create 2017-11-01 14:11
 **/
public class SubSource2 implements Source {

  @Override
  public void method() {
    System.out.println("具体类2");
  }
}
