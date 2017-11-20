package liu.yan.pattern.command;

/**
 * 发出命令
 *
 * @author 刘研
 * @create 2017-11-20 15:41
 **/
public class Invoker {

  private Commond commond;

  public Invoker(Commond commond) {
    this.commond = commond;
  }

  public void action() {
    commond.exe();
  }
}
