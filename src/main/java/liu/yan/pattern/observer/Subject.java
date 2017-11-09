package liu.yan.pattern.observer;

import java.util.Observable;

/**
 * 观察目标
 *
 * @author 刘研
 * @create 2017-11-09 10:47
 **/
public class Subject extends Observable implements ISubject{

  @Override
  public void operation() {
    setChanged();
    super.notifyObservers();
  }
}
