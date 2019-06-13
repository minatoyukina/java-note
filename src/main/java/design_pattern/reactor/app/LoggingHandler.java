package design_pattern.reactor.app;

import design_pattern.reactor.framework.AbstractNioChannel;
import design_pattern.reactor.framework.ChannelHandler;
import design_pattern.reactor.framework.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

public class LoggingHandler implements ChannelHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingHandler.class);
    private static final byte[] ACK = "Data logged successfully".getBytes();

    @Override
    public void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key) {
        if (readObject instanceof ByteBuffer) {
            doLogging((ByteBuffer) readObject);
            sendReply(channel, key);
        } else if ((readObject instanceof NioDatagramChannel.DatagramPacket)) {
            NioDatagramChannel.DatagramPacket datagram = (NioDatagramChannel.DatagramPacket) readObject;
            doLogging(datagram.getData());
            sendReply(channel, datagram, key);
        }
    }

    private void sendReply(AbstractNioChannel channel, SelectionKey key) {
        ByteBuffer buffer = ByteBuffer.wrap(ACK);
        channel.write(buffer, key);
    }

    private void sendReply(AbstractNioChannel channel, NioDatagramChannel.DatagramPacket incomingPacket, SelectionKey key) {
        NioDatagramChannel.DatagramPacket replyPacket = new NioDatagramChannel.DatagramPacket(ByteBuffer.wrap(ACK));
        replyPacket.setReceiver(incomingPacket.getSender());
        channel.write(replyPacket, key);
    }

    private void doLogging(ByteBuffer data) {
        LOGGER.info(new String(data.array(), 0, data.limit()));
    }
}
