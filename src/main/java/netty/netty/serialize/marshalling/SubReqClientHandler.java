package netty.netty.serialize.marshalling;

import com.google.protobuf.ByteString;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.netty.serialize.protobuf.SubscribeReqProto;

import java.util.ArrayList;
import java.util.List;

public class SubReqClientHandler extends ChannelInboundHandlerAdapter {
    public SubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReqProto.SubscribeReq subReq(int i) {
        SubscribeReqProto.SubscribeReq.Builder req = SubscribeReqProto.SubscribeReq.newBuilder();
        req.setPhoneNumber("12345678900");
//        req.setProductName("Netty权威指南");
        req.setProductNameBytes(ByteString.copyFromUtf8("Netty权威指南"));
        req.setSubReqID(i);
        req.setUserName("ccq");
        List<String> address = new ArrayList<>();
        address.add("Nanjing YuHuaChang");
        address.add("Beijing LiuLiChang");
        address.add("ShenZhen HongShuLin");
        req.addAllAddress(address);
        return req.build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Receive server response: [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
