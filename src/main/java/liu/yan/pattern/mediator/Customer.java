package liu.yan.pattern.mediator;

/**
 * @author 刘研
 * @create 2017-11-28 14:14
 **/
public class Customer {

  public static void main(String[] args) {
    Member commonMember = new CommonMember("普通用户");
    Member diamonMember = new DiamonMember("钻石用户");
    AbstractChatRoom chatRoom = new ChatRoom();
    chatRoom.register(commonMember);
    chatRoom.register(diamonMember);
    commonMember.sendText(diamonMember,"哈哈");
    diamonMember.sendText(commonMember,"啦啦");
  }
}
