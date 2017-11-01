package liu.yan.acm.bridge.example;

/**
 * @author 刘研
 * @create 2017-11-01 14:28
 **/
public class RedColor implements IColor {

  @Override
  public void paint() {
    System.out.println("把字体颜色变成红色");
  }
}
