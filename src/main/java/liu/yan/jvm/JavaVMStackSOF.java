package liu.yan.jvm;

/**
 * 栈内存溢出测试
 * 参数：-Xss128k
 * @author 刘研
 * @create 2017-11-02 22:14
 **/
public class JavaVMStackSOF {

  private int stackLength = 1;

  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) {
    JavaVMStackSOF oom = new JavaVMStackSOF();
    try {
      oom.stackLeak();
    } catch (Exception e) {
      System.out.println(oom.stackLength);
      throw e;
    }
  }
}
