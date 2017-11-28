package liu.yan.pattern.mediator;

/**
 * @author 刘研
 * @create 2017-11-28 13:47
 **/
public abstract class AbstractChatRoom {

 abstract void register(Member member);
 abstract void sendText(Member from,Member to,String content);
 abstract void sendImg(Member from ,Member to ,String img);
}
