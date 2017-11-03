package liu.yan.pattern.bridge.example;

/**
 * @author 刘研
 * @create 2017-11-01 14:28
 **/
public class BigPen extends AbstractPen{

  @Override
  void write() {
    System.out.println("写大字");
    super.getColor().paint();
  }
}
