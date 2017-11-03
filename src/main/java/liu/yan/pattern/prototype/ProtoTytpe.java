package liu.yan.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式：将对象克隆一份
 * 一般clone需要满足：1.克隆后的对象与原对象不是同一个对象，obj.clone()!=obj
 *                    2.克隆后的对象与原对象类型一样，obj.clone().getClass()==obj.getClass()
 *                    3.克隆后的对象与原对象equals，obj.clone().equals(obj)
 * @author 刘研
 * @create 2017-10-25 10:59
 **/
public class ProtoTytpe implements Cloneable, Serializable {

  /*
  浅复制，复制之后，基本类型会重新创建，而引用类型还是指向的原对象所指向的
   */
  public Object shallowClone() throws CloneNotSupportedException {
    ProtoTytpe proto = (ProtoTytpe) super.clone();
    return proto;
  }

  /*
  深复制，复制之后，基本类型和引用类型都会重新创建
   */
  public Object deepClone() throws IOException, ClassNotFoundException {
    /* 写入当前对象的二进制流 */
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);
    return ois.readObject();
  }
}
