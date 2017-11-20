package liu.yan.pattern.command;

/**
 * 接受者
 *
 * @author 刘研
 * @create 2017-11-20 15:39
 **/
public class Receiver implements IReceiver{

  @Override
  public void action() {
    System.out.println("执行命令");
  }
}
