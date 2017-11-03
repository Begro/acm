package liu.yan.pattern.bridge.example;

/**
 * 抽象类
 *
 * @author 刘研
 * @create 2017-11-01 14:24
 **/
public abstract class AbstractPen {

  private IColor color;

  abstract void write();

  public IColor getColor() {
    return color;
  }

  public void setColor(IColor color) {
    this.color = color;
  }
}
