package lambda.option;


import java.util.concurrent.*;

public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callback callback = answer -> answer + 1;
        int b = 4;
//        FutureTask<Integer> task = new FutureTask<>(new A(b, callback));
        ExecutorService service = Executors.newCachedThreadPool();
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> b + 1, service);
        CompletableFuture.runAsync(() -> System.out.println(b + 1),service);
//        System.out.println(future.get());

//        new Thread(task).start();
        System.out.println(b);
//        service.shutdown();

    }
}


interface Callback {
    int add(int answer);
}

class A implements Callable<Integer> {
    private Callback callback;
    private int answer;

    A(int answer, Callback callback) {
        this.callback = callback;
        this.answer = answer;
    }

    @Override
    public Integer call() {
        return callback.add(answer);
    }
}
