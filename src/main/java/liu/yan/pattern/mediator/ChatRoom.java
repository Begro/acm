package liu.yan.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘研
 * @create 2017-11-28 14:11
 **/
public class ChatRoom extends  AbstractChatRoom {

  private List<Member> members = new ArrayList<>();
  @Override
  void register(Member member) {
    member.setRoom(this);
    members.add(member);
  }

  @Override
  void sendText(Member from, Member to, String content) {
    System.out.println(from.name+"--发送信息给--"+to.name+"内容："+content);
    to.receiveText(from,content);
  }

  @Override
  void sendImg(Member from, Member to, String img) {
    System.out.println(from.name+"--发送信息给--"+to.name+"内容："+img);
    to.receiveText(from,img);
  }


}
