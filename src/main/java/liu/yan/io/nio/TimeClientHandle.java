package liu.yan.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liu yan
 * @description
 * @date 2018/5/28
 */
public class TimeClientHandle implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;


    public TimeClientHandle(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            selector.select(100);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            SelectionKey selectionKey;
            while (iterator.hasNext()) {
                selectionKey = iterator.next();
                iterator.remove();
                handleInput(selectionKey);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            if (selectionKey.isConnectable()) {
                if (channel.finishConnect()) {
                    channel.register(selector, SelectionKey.OP_READ);
                    dowrite();
                } else {
                    System.out.println("连接失败");
                }

            }
            if (selectionKey.isReadable()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int read = channel.read(byteBuffer);
                if (read > 0) {
                    byteBuffer.flip();
                    byte[] bs = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bs);
                    String body = new String(bs, "utf-8");
                    System.out.println("client receive:" + body);
                } else if (read < 0) {
                    selectionKey.channel();
                    channel.close();
                }

            }

        }
    }

    private void doConnect() throws IOException {
        if (socketChannel.connect(new InetSocketAddress(host, port))) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            dowrite();
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }


    }

    private void dowrite() throws IOException {
        byte[] out = "liuyantest client".getBytes();

        ByteBuffer byteBuffer = ByteBuffer.allocate(out.length);
        byteBuffer.put(out);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            System.out.println("client write finish");
        }

    }
}
