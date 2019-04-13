package callback;

import java.util.concurrent.*;

public class Completable {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<String> task = new FutureTask<>(new Call());
        service.submit(task);
        CompletableFuture<String> future = CompletableFuture.supplyAsync((() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "java";
        }), service);
        System.out.println(task.get());
        future.thenAcceptAsync(System.out::println);
        future.complete("scala");
        System.out.println("world");
        service.shutdown();
    }

}

class Call implements Callable<String> {
    @Override
    public String call() {
        return "hello";
    }
}



