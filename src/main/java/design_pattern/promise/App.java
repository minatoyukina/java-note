package design_pattern.promise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static final String DEFAULT_URL = "https://raw.githubusercontent.com/feixiao/DesignPattern/master/Java/promise/README.md";
    private final ExecutorService service;
    private final CountDownLatch stopLatch;

    private App() {
        service = Executors.newFixedThreadPool(2);
        stopLatch = new CountDownLatch(1);
    }

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        try {
            app.promiseUsage();
        } finally {
            app.stop();
        }
    }

    private void promiseUsage() {
        download().thenApply(Utility::characterFrequency).thenApply(Utility::lowestFrequencyChar).thenAccept(character -> {
            LOGGER.info("Char with lowest frequency is: {}", character);
            stopLatch.countDown();
        }).thenAccept(s -> System.out.println(Thread.currentThread().getName() + " frequency finished"));
        download().thenApply(Utility::countLines).thenAccept(count -> {
            LOGGER.info("Line count is: {}", count);
            stopLatch.countDown();
        }).thenAccept(s -> System.out.println(Thread.currentThread().getName() + " count finished"));
    }

    private Promise<String> download() {
        return new Promise<String>()
                .fulfillInAsync(
                        () -> Utility.downloadFile(App.DEFAULT_URL), service)
                .onError(
                        throwable -> {
                            throwable.printStackTrace();
                            stopLatch.countDown();
                        });
    }

    private void stop() throws InterruptedException {
        stopLatch.await();
        service.shutdownNow();
    }

}
