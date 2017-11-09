package liu.yan.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者：观察目标可以增加观察者，在变化后通知所有的观察者
 * 角色：抽象观察目标，观察目标，抽象观察者，观察者
 * java中已经实现了观察目标和抽象观察者
 * 优点：1.观察者与目标之间抽象的耦合
 *       2.支持广播
 *       3.符合开闭原则
 * 缺点：1.如果一个观察目标有很多观察者，通知会耗费时间
 *       2.如果观察者与观察目标有循环依赖，会导致系统崩溃
 *       3.观察者只知道目标发生变化，却不知道是怎么发生变化的
 * 场景：1.一方面需要依赖另一方面，将两方面独立封装
 *        2.一方变化会导致多个对象变化，并且不知道具体哪些对象或者是多少对象
 *        3.类似于触发链，A影响B，B影响C。。。。。
 * @author 刘研
 * @create 2017-11-09 10:53
 **/
public class MyObserver implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    System.out.println(o.getClass().getName());
    System.out.println(arg);
  }
}
