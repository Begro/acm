package liu.yan.pattern.strategy;

/**
 * @author 刘研
 * @create 2017-11-07 13:48
 **/
public class Customer {

  public static void main(String[] args) {
    Context context = new Context();
    context.setStrategy(new StrategyA());
    context.algorithm();
  }
}
