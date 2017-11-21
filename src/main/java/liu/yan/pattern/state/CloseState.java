package liu.yan.pattern.state;

/**
 * @author 刘研
 * @create 2017-11-21 19:32
 **/
public class CloseState extends State {

  @Override
  void open() {
    context.setState(Context.open);
    context.open();
  }

  @Override
  void close() {
    System.out.println("close ....");
  }

  @Override
  void run() {
    context.setState(Context.run);
    context.run();
  }

  @Override
  void stop() {

  }
}
