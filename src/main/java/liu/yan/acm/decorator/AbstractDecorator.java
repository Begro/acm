package liu.yan.acm.decorator;

/**
 * 抽象装饰类
 *
 * @author 刘研
 * @create 2017-10-30 9:37
 **/
public abstract class AbstractDecorator implements ISources {

  private ISources sources;


  public void setSources(ISources sources) {
    this.sources = sources;
  }

  @Override
  public void method() {
    sources.method();
  }
}
