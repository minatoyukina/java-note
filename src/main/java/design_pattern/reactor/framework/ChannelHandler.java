package design_pattern.reactor.framework;

import java.nio.channels.SelectionKey;

public interface ChannelHandler {
    void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key);
}
