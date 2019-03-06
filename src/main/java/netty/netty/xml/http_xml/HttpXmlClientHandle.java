package netty.netty.xml.http_xml;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.netty.xml.OrderFactory;

public class HttpXmlClientHandle extends SimpleChannelInboundHandler<HttpXmlResponse> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpXmlResponse msg) {
        System.out.println("The client receive response of http header is: " + msg.getHttpResponse().headers().names());
        System.out.println("The client receive response of http body is: " + msg.getResult());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        HttpXmlRequest request = new HttpXmlRequest(null, OrderFactory.create(12345));
        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
