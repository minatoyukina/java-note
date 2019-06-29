package design_pattern.red_write_lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ReaderWriterLock lock = new ReaderWriterLock();

        IntStream.range(0, 5).forEach(i -> service.submit(new Reader("Reader " + i, lock.readLock())));
        IntStream.range(0, 5).forEach(i -> service.submit(new Writer("Writer " + i, lock.writeLock())));
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error("error waiting for ExecutorService shutdown");
        }
    }
}
