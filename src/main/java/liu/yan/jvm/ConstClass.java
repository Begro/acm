package liu.yan.jvm;

/**
 * @author 刘研
 * @create 2017-11-20 21:27
 **/
public class ConstClass {

  static {
    System.out.println("init~~~~~~~~~~~~~~");
  }

  public static final String HELLO = "11111";
}
