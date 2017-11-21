package liu.yan.pattern.state;

/**
 * @author 刘研
 * @create 2017-11-21 19:15
 **/
public class Context {

  private State state;
  static State open;
  static State close;
  static State run;
  static State stop;

  public Context() {
    open = new OpenState();
    close = new CloseState();
    run = new RunState();
    stop = new StopState();
  }

  /**
   * Setter for property 'state'.
   *
   * @param state
   *     Value to set for property 'state'.
   */
  public void setState(State state) {
    this.state = state;
    this.state.setContext(this);
  }

  public void open() {
    state.open();
  }

  public void close() {
    state.close();
  }

  public void run() {
    state.run();
  }

  public void stop() {
    state.stop();
  }


}
