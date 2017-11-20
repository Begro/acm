package liu.yan.pattern.command;

/**
 * 具体命令对象
 *
 * @author 刘研
 * @create 2017-11-20 15:38
 **/
public class MyCommond implements Commond {

  private IReceiver receiver;

  public MyCommond(IReceiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public void exe() {
    receiver.action();
  }
}
