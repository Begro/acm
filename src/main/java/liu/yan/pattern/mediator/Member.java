package liu.yan.pattern.mediator;

/**
 * @author 刘研
 * @create 2017-11-28 13:46
 **/
public abstract class Member {

  protected String name;

  protected AbstractChatRoom room;

  abstract void sendText(Member to, String content);

  abstract void sendImg(Member to, String content);

  void receiveText(Member from, String content) {
    System.out.println("接受text消息" + from.name + content);
  }

  void receiveImg(Member from, String content) {
    System.out.println("接受img消息" + from.name+ content);
  }


  /**
   * Getter for property 'name'.
   *
   * @return Value for property 'name'.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for property 'name'.
   *
   * @param name
   *     Value to set for property 'name'.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for property 'room'.
   *
   * @return Value for property 'room'.
   */
  public AbstractChatRoom getRoom() {
    return room;
  }

  /**
   * Setter for property 'room'.
   *
   * @param room
   *     Value to set for property 'room'.
   */
  public void setRoom(AbstractChatRoom room) {
    this.room = room;
  }
}
