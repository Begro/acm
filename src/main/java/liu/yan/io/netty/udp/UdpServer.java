package liu.yan.io.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @author liu yan
 * @description
 * @date 2018/6/2
 */
public class UdpServer {
    private void bind() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST, true)
                .handler(new UdpServerHandler());
        try {
            bootstrap.bind(8080).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new UdpServer().bind();
    }
}
