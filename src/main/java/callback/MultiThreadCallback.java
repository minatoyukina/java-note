package callback;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

public class MultiThreadCallback {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                TimeUnit.SECONDS.sleep(1);
                return "str";
            }
        });
        System.out.println(future.get());
        service.shutdown();
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("dasds");
                return new Random().nextInt();
            }
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void test() {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
        FutureTask futureTask = new FutureTask(callable);

    }
}
