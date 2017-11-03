package liu.yan.pattern.bridge;

/**
 * 抽象桥
 *
 * @author 刘研
 * @create 2017-11-01 14:12
 **/
public abstract class AbstractBridge {

  private Source source;

  abstract void doit();

  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    this.source = source;
  }
}
