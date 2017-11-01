package liu.yan.acm.bridge.example;

/**
 * @author 刘研
 * @create 2017-11-01 14:29
 **/
public class Customer {

  public static void main(String[] args) {
    AbstractPen pen = new BigPen();
    pen.setColor(new RedColor());
    pen.write();
  }
}
