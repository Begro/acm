package liu.yan.io.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author liu yan
 * @description
 * @date 2018/5/29
 */
public class TImeClientHandler extends ChannelInboundHandlerAdapter {
private final ByteBuf byteBuf;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bs = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bs);
        System.out.println(new String(bs,"utf-8"));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    public TImeClientHandler( ) {
        byte[] bs = "liuyan test".getBytes();
        byteBuf = Unpooled.buffer(bs.length);
        byteBuf.writeBytes(bs);
    }
}
