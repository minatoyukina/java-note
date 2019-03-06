package callback;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

public class Promise {

    public static void main(String[] args) {
        Supplier<Integer> momPurse = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("well...");
            return 100;
        };

        ExecutorService ex = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> promise = CompletableFuture.supplyAsync(momPurse, ex);
        promise.thenAccept(u -> System.out.println("Thank you mom for $" + u));
        System.out.println("OK...");
        promise.complete(sum(200));
    }

    private static int sum(int a) {
        int sum = 0;
        for (int i = 0; i < a; i++) {
            sum += i;
        }
        return sum;
    }
}


