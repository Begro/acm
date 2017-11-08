package liu.yan.pattern.template;

/**
 * 抽象类
 * 角色：抽象类，具体类
 * 抽象类中负责提取子类中的共有方法和算法的整个骨架，具体的方法延迟到子类中实现
 * 并且抽象类中可以创建一个钩子方法，子类可以重写来改变父类行为
 * 优点：代码复用，反向控制
 * 缺点：类数量会变多，比较抽象
 * 场景：一次性实现算法的不变部分与基本骨架，将变化的留给子类实现
 *      子类中共有方法提取出来，避免代码重复
 *      复杂算法分解
 * @author 刘研
 * @create 2017-11-08 10:00
 **/
public abstract class AbstractClass {

  public void template() {
    method1();
    if (isDone()) {
      method2();
    }
  }

  abstract void method1();

  abstract void method2();

  public boolean isDone() {
    return true;
  }
}
