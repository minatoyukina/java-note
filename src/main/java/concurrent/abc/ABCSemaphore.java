package concurrent.abc;

import java.util.concurrent.Semaphore;

public class ABCSemaphore {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);
    private static int count = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();
                    System.out.println(count++ + Thread.currentThread().getName());
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println(count++ + Thread.currentThread().getName());
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println(count++ + Thread.currentThread().getName());
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}
