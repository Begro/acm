package liu.yan.pattern.strategy;

/**
 * 环境类
 * 策略模式：将算法封装到不同类中，每个类只负责一种算法，使用那个算法由客户端决定，策略模式只负责维护算法本身
 * 角色：抽象算法，具体算法，环境类
 * 优点：可以在不修改原代码的基础上增加新的算法，避免使用多重条件语句的状态转移
 * 缺点：客户端必须知道所有的算法，并且类会变得很多
 *
 * @author 刘研
 * @create 2017-11-07 13:38
 **/
public class Context {

  private IStrategy strategy;

  public void algorithm() {
    strategy.algorithm();
  }

  /**
   * Setter for property 'strategy'.
   *
   * @param strategy
   *     Value to set for property 'strategy'.
   */
  public void setStrategy(IStrategy strategy) {
    this.strategy = strategy;
  }
}
