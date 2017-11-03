package liu.yan.pattern.bridge.example;

/**
 * @author 刘研
 * @create 2017-11-01 14:29
 **/
public class BlackColor implements IColor{

  @Override
  public void paint() {
    System.out.println("把字体变成黑色");
  }
}
