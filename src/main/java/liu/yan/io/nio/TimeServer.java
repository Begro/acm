package liu.yan.io.nio;

/**
 * @author liu yan
 * @description
 * @date 2018/5/28
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MulttiplexerTimeServer m = new MulttiplexerTimeServer(port);
        new Thread(m, "MTO_001").start();
    }
}
