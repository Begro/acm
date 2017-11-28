package liu.yan.pattern.mediator;

/**
 * @author 刘研
 * @create 2017-11-28 14:09
 **/
public class DiamonMember extends Member {

  public DiamonMember(String name) {
    this.name=name;
  }

  @Override
  void sendText(Member to, String content) {
    room.sendText(this,to,content);
  }

  @Override
  void sendImg(Member to, String content) {
    room.sendImg(this,to,content);
  }
}
