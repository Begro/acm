package liu.yan.pattern.state;

/**
 * @author 刘研
 * @create 2017-11-21 19:32
 **/
public class RunState extends State {

  @Override
  void open() {
    throw new RuntimeException("运行中无法打开");
  }

  @Override
  void close() {

  }

  @Override
  void run() {
    System.out.println("run ....");
  }

  @Override
  void stop() {
    context.setState(Context.stop);
    context.stop();
  }
}
