package liu.yan.pattern.state;

/**
 * @author 刘研
 * 状态模式：一个对象在其内部状态改变时，改变其行为
 * 角色：环境类，抽象状态类，具体状态类
 * 环境类实际上就是拥有状态的对象，环境类有时候可以充当状态管理器(State Manager)的角色，可以在环境类中对状态进行切换操作。
 * 抽象状态类可以是抽象类，也可以是接口，不同状态类就是继承这个父类的不同子类，
 * 状态类的产生是由于环境类存在多个状态，
 * 同时还满足两个条件：这些状态经常需要切换，在不同的状态下对象的行为不同。
 * 因此可以将不同对象下的行为单独提取出来封装在具体的状态类中，
 * 使得环境类对象在其内部状态改变时可以改变它的行为，对象看起来似乎修改了它的类，
 * 而实际上是由于切换到不同的具体状态类实现的。
 *
 *
 * @create 2017-11-21 19:09
 **/
public abstract class State {

  protected Context context;

  /**
   * Setter for property 'context'.
   *
   * @param context
   *     Value to set for property 'context'.
   */
  public void setContext(Context context) {
    this.context = context;
  }

  abstract void open();

  abstract void close();

  abstract void run();

  abstract void stop();
}
