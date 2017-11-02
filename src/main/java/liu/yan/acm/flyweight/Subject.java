package liu.yan.acm.flyweight;

/**
 * 具体对象
 *
 * @author 刘研
 * @create 2017-11-02 14:57
 **/
public class Subject implements ISubject {

  private String X;
  private String a;
  private String b;

  public Subject() {
    this.setX("123");
  }

  /**
   * Getter for property 'a'.
   *
   * @return Value for property 'a'.
   */
  public String getA() {
    return a;
  }

  /**
   * Setter for property 'a'.
   *
   * @param a
   *     Value to set for property 'a'.
   */
  @Override
  public void setA(String a) {
    this.a = a;
  }

  /**
   * Getter for property 'b'.
   *
   * @return Value for property 'b'.
   */
  public String getB() {
    return b;
  }

  /**
   * Setter for property 'b'.
   *
   * @param b
   *     Value to set for property 'b'.
   */
  @Override
  public void setB(String b) {
    this.b = b;
  }

  @Override
  public void setX(String X) {
    this.X = X;
  }


  @Override
  public void method() {
    System.out.println("啦啦啦");
  }
}
