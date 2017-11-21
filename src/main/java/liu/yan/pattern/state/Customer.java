package liu.yan.pattern.state;

/**
 * @author 刘研
 * @create 2017-11-21 19:41
 **/
public class Customer {

  public static void main(String[] args) {
    Context context = new Context();
    context.setState(Context.run);
    context.stop();
    context.open();
    context.close();
    context.run();
  }
}
