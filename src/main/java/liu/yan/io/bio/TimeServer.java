package liu.yan.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liu yan
 * @description
 * @date 2018/5/24
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        ServerSocket server = null;
        try {

            server = new ServerSocket(port);
            System.out.println("start in port " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                System.out.println(socket);
                new Thread(new TimerServerHandler(socket)).start();
            }


        } finally {
            System.out.println(111111);
            if (server != null) {
                server.close();
                server = null;
            }

        }

    }
}
