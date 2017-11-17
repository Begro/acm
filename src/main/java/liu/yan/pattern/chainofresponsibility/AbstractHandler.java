package liu.yan.pattern.chainofresponsibility;

/**
 * 抽象处理类
 * 责任链模式：可以使一条直线、一个环或者是一个树状结构。
 * 链上的每一个对象都是一个处理类，将请求的处理者组装成一条链。
 * 让链上的处理者都有可能接受请求，并沿着链传递，直到有一个处理类可以处理
 * 角色：抽象处理者，具体处理者
 * 优点：耦合度低
 * 缺点：不保证请求一定被处理，可能造成循环调用
 * 场景：有多个对象可以处理一个请求，但是具体哪个处理要运行时知道。在不明确接受者的情况下，向多个对象同时提交请求
 *
 *
 * @author 刘研
 * @create 2017-11-17 14:06
 **/
public  abstract class AbstractHandler {

  private AbstractHandler handler;

  abstract void handle();

  abstract boolean enable();

  public AbstractHandler getHandler() {
    return handler;
  }

  public void setHandler(AbstractHandler handler) {
    this.handler = handler;
  }
}
