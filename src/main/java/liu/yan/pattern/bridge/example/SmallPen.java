package liu.yan.pattern.bridge.example;

/**
 * 小笔
 *
 * @author 刘研
 * @create 2017-11-01 14:26
 **/
public class SmallPen extends  AbstractPen {

  @Override
  void write() {
    System.out.println("写小字体");
    super.getColor().paint();
  }
}
