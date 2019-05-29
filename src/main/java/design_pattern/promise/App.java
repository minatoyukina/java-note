package design_pattern.promise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
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
        stopLatch = new CountDownLatch(2);
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
        calculateLineCount();
        calculateLowestFrequencyChar();
    }

    private void calculateLowestFrequencyChar() {
        lowestFrequencyChar().thenAccept(character -> {
            LOGGER.info("Char with lowest frequency is: {}", character);
            taskCompleted();
        });
    }

    private void calculateLineCount() {
        countLines().thenAccept(count -> {
            LOGGER.info("Line count is: {}", count);
            taskCompleted();
        });
    }

    private Promise<Character> lowestFrequencyChar() {
        return characterFrequency().thenApply(Utility::lowestFrequencyChar);
    }

    private Promise<Map<Character, Integer>> characterFrequency() {
        return download(DEFAULT_URL).thenApply(Utility::characterFrequency);
    }

    private Promise<Integer> countLines() {
        return download(DEFAULT_URL).thenApply(Utility::countLines);
    }

    private Promise<String> download(String urlString) {
        return new Promise<String>()
                .fulfillInAsync(
                        () -> Utility.downloadFile(urlString), service
                ).onError(
                        throwable -> {
                            throwable.printStackTrace();
                            taskCompleted();
                        }
                );
    }

    private void stop() throws InterruptedException {
        stopLatch.await();
        service.shutdownNow();
    }

    private void taskCompleted() {
        stopLatch.countDown();
    }
}
