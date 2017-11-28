package liu.yan.pattern.mediator;

/**
 * @author 刘研
 * @create 2017-11-28 13:58
 **/
public class CommonMember extends Member{

  public CommonMember(String name) {
    this.name= name;
  }

  @Override
  void sendText(Member to, String content) {
    room.sendText(this,to,content);
  }

  @Override
  void sendImg(Member to, String content) {
    throw new RuntimeException("普通用户无法发送图片");
  }
}
