package liu.yan.pattern.command;

/**
 * @author 刘研
 * @create 2017-11-20 15:42
 * 命令模式：发送者和接受者完全解耦，发送者与接受者之间没有直接引用关系，发送请求的对象只知道如何发送请求，不必知道如何完成请求
 * 角色：抽象命令类，具体命令类，调用者，接受者
 * 优点：降低耦合度，新的命令比较容易添加，可以方便实现undo和redo
 **/
public class Customer {

  public static void main(String[] args) {
    IReceiver receiver = new Receiver();
    Commond commond = new MyCommond(receiver);
    Invoker invoker = new Invoker(commond);
    invoker.action();
  }
}
