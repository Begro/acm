package liu.yan.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author liu yan
 * @description
 * @date 2018/6/2
 */
public class TcpServerHandler extends ChannelInboundHandlerAdapter {
    private int count;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bs = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bs);
        System.out.println("receive :" + new String(bs, "utf-8"));
        System.out.println("计数器：" + count++);
        String out = new Date().toString();
        ByteBuf byteBuf1 = Unpooled.copiedBuffer(out.getBytes());
        ctx.channel().writeAndFlush(byteBuf1);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
