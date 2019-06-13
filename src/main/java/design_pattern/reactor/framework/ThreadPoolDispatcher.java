package design_pattern.reactor.framework;

import java.nio.channels.SelectionKey;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDispatcher implements Dispatcher {
    private final ExecutorService executorService;

    public ThreadPoolDispatcher(int pollSize) {
        this.executorService = Executors.newFixedThreadPool(pollSize);
    }

    @Override
    public void onChannelReadEvent(AbstractNioChannel channel, Object readObject, SelectionKey key) {
        executorService.execute(() -> channel.getHandler().handleChannelRead(channel, readObject, key));
    }

    @Override
    public void stop() throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(4, TimeUnit.SECONDS);
    }
}
