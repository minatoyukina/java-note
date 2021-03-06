package netty.netty.xml.http_xml;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.net.InetAddress;
import java.util.List;

@SuppressWarnings("deprecation")
public class HttpXmlRequestEncoder extends AbstractHttpXmlEncoder<HttpXmlRequest> {
    @Override
    protected void encode(ChannelHandlerContext ctx, HttpXmlRequest msg, List<Object> out) throws Exception {
        ByteBuf body = encode0(ctx, msg.getBody());
        FullHttpRequest request = msg.getRequest();
        if (request == null) {
            request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/do", body);
            HttpHeaders httpHeaders = request.headers();
            httpHeaders.set(HttpHeaders.Names.HOST, InetAddress.getLocalHost().getHostAddress());
            httpHeaders.set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.CLOSE);
            httpHeaders.set(HttpHeaders.Names.ACCEPT_ENCODING, HttpHeaders.Values.GZIP + ',' + HttpHeaders.Values.DEFLATE);
            httpHeaders.set(HttpHeaders.Names.ACCEPT_CHARSET, "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
            httpHeaders.set(HttpHeaders.Names.ACCEPT_LANGUAGE, "zh");
            httpHeaders.set(HttpHeaders.Names.USER_AGENT, "Netty xml Http Client side");
            httpHeaders.set(HttpHeaders.Names.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        }
        HttpHeaders.setContentLength(request, body.readableBytes());
        out.add(request);
    }
}
