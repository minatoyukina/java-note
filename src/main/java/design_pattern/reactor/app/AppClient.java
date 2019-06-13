package design_pattern.reactor.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppClient.class);
    private final ExecutorService service = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        AppClient appClient = new AppClient();
        appClient.start();
    }

    private void start() {
        LOGGER.info("Starting logging clients");
        service.execute(new TcpLoggingClient("Client 1", 6666));
        service.execute(new TcpLoggingClient("Client 1", 6666));
        service.execute(new TcpLoggingClient("Client 1", 6666));
        service.execute(new TcpLoggingClient("Client 1", 6666));
    }

    private void stop() {
        service.shutdown();
        if (!service.isTerminated()) {
            service.shutdownNow();
            try {
                service.awaitTermination(1000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("exception awaiting termination", e);
            }
        }
        LOGGER.info("Logging clients stopped");
    }

    private static void artificialDelayOf(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.error("sleep interrupted", e);
        }
    }

    static class TcpLoggingClient implements Runnable {
        private final int serverPort;
        private final String clientName;

        @Override
        public void run() {
            try (Socket socket = new Socket(InetAddress.getLocalHost(), serverPort)) {
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream);
                sendLogRequests(writer, socket.getInputStream());
            } catch (IOException e) {
                LOGGER.error("error sending requests", e);
                throw new RuntimeException(e);
            }
        }

        private void sendLogRequests(PrintWriter writer, InputStream inputStream) throws IOException {
            for (int i = 0; i < 4; i++) {
                writer.println(clientName + " - Log request: " + i);
                writer.flush();
                byte[] data = new byte[1024];
                int read = inputStream.read(data, 0, data.length);
                if (read == 0) {
                    LOGGER.info("Read zero bytes");
                } else {
                    LOGGER.info(new String(data, 0, read));
                }
                artificialDelayOf(100);
            }
        }

        TcpLoggingClient(String clientName, int serverPort) {
            this.clientName = clientName;
            this.serverPort = serverPort;
        }
    }
}
