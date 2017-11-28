package liu.yan.jvm;

/**
 * @author 刘研
 * @create 2017-11-22 21:15
 **/
public class DeapLoopClass {

  static {
    if (true) {
      System.out.println(Thread.currentThread() + "init deaploopclass");
      while (true) {
      }
    }
  }


}
