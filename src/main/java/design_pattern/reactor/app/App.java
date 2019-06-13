package design_pattern.reactor.app;

import design_pattern.reactor.framework.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private NioReactor reactor;
    private List<AbstractNioChannel> channels = new ArrayList<>();
    private Dispatcher dispatcher;

    private App(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static void main(String[] args) throws IOException {
        new App(new ThreadPoolDispatcher(2)).start();
    }

    private void start() throws IOException {
        reactor = new NioReactor(dispatcher);
        LoggingHandler loggingHandler = new LoggingHandler();
        reactor.registerChannel(tcpChannel(6666, loggingHandler))
                .registerChannel(tcpChannel(6667, loggingHandler))
                .registerChannel(tcpChannel(6668, loggingHandler)).start();
    }

    private void stop() throws IOException, InterruptedException {
        reactor.stop();
        dispatcher.stop();
        for (AbstractNioChannel channel : channels) {
            channel.getJavaChannel().close();
        }
    }

    private AbstractNioChannel tcpChannel(int port, ChannelHandler handler) throws IOException {
        NioServerSocketChannel channel = new NioServerSocketChannel(port, handler);
        channel.bind();
        channels.add(channel);
        return channel;
    }

    private AbstractNioChannel udpChannel(int port, ChannelHandler handler) throws IOException {
        NioDatagramChannel channel = new NioDatagramChannel(port, handler);
        channel.bind();
        channels.add(channel);
        return channel;
    }
}
