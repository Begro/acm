package liu.yan.pattern.observer;

import java.util.Observer;

/**
 * 客户端
 *
 * @author 刘研
 * @create 2017-11-09 10:54
 **/
public class Customer {

  public static void main(String[] args) {
    Subject subject = new Subject();

    Observer observer1 = new MyObserver();
    Observer observer2 = new MyObserver();
    subject.addObserver(observer1);
    subject.addObserver(observer2);

    subject.operation();
  }
}
