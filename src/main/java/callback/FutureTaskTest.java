package callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        Task task=new Task();
        FutureTask<Integer> futureTask=new FutureTask<>(task);
        service.submit(futureTask);
        service.shutdown();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("主线程正在执行任务 "+Thread.currentThread().getName());

        try {
            System.out.println("task运行结果 " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }


}
