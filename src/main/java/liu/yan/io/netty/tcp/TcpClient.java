package liu.yan.io.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author liu yan
 * @description
 * @date 2018/5/29
 */
public class TcpClient {
    public void connect(String ip, int port) throws InterruptedException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TcpClientHandler());
                        }
                    });
            ChannelFuture sync = bootstrap.connect(ip, port).sync();
            sync.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new TcpClient().connect("127.0.0.1", 8080);
    }
}
