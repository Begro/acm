package liu.yan.io.netty.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.util.concurrent.ThreadLocalRandom;


/**
 * @author liu yan
 * @description
 * @date 2018/6/2
 */
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final String[] DIC = {"只要功夫深，铁杵磨成针", "刘研，代记婷", "老骥伏枥志在千里"};

    private String getQuote() {
        int i = ThreadLocalRandom.current().nextInt(DIC.length);
        return DIC[i];
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String req = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("查询结果：" + getQuote(), CharsetUtil.UTF_8), msg.sender()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
