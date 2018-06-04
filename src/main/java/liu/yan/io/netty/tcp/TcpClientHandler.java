package liu.yan.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author liu yan
 * @description
 * @date 2018/6/2
 */
public class TcpClientHandler extends ChannelInboundHandlerAdapter {
    private byte[] bs = "tcp test by liuyan hahaha".getBytes();

    int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 20; i++) {
            ByteBuf byteBuf = Unpooled.buffer(bs.length);
            byteBuf.writeBytes(bs);
            ctx.channel().writeAndFlush(byteBuf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bs = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bs);
        System.out.println("client receive :" + new String(bs, "utf-8"));
        System.out.println("计数器" + count++);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
