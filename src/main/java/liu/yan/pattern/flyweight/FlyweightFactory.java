package liu.yan.pattern.flyweight;

import java.util.Vector;

/**
 * 工厂类
 * 享元模式，减少对象的创建，分内部状态与外部状态。
 * 内部状态是在对象内部，不会改变的
 * 外部状态是传递进来的参数。
 * 优点：减少对象的创建，相同的对象在系统中可以只有一份
 * 缺点：需要区分内部状态与外部状态，
 * 应用场景：有大量相同或相似的对象时
 * 连接池，String
 *
 * @author 刘研
 * @create 2017-11-02 14:59
 **/
public class FlyweightFactory {

  Vector<ISubject> subjects = new Vector<>();

  public ISubject getSubject(String a, String b) {
    if (subjects.isEmpty()) {
      ISubject subject = new Subject();
      subject.setA(a);
      subject.setB(b);
      subjects.add(subject);
    }
    ISubject subject = subjects.get(0);
    subjects.remove(0);
    return subject;
  }

  public void release(ISubject subject) {
    if (subject == null) {
      return;
    }
    subjects.add(subject);
  }
}
