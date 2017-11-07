package liu.yan.pattern.strategy;

/**
 * @author 刘研
 * @create 2017-11-07 13:48
 **/
public class StrategyA implements IStrategy {

  @Override
  public void algorithm() {
    System.out.println("具体算法");
  }
}
