package liu.yan.pattern.state;

/**
 * @author 刘研
 * @create 2017-11-21 19:17
 **/
public class OpenState extends State {

  @Override
  void open() {
    System.out.println("open....");
  }

  @Override
  void close() {
    context.setState(Context.close);
    context.close();
  }

  @Override
  void run() {
    throw new RuntimeException("开门时无法运行");
  }

  @Override
  void stop() {

  }
}
