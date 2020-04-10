package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
    private static final ReentrantLock l1 = new ReentrantLock();
    private static final ReentrantLock l2 = new ReentrantLock();

    private static void sync() throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    synchronized (o1) {
                        Thread.sleep(1000);
                        synchronized (o2) {
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("l1 interrupted");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    synchronized (o2) {
                        Thread.sleep(1000);
                        synchronized (o1) {
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("t2 interrupted");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        thread1.interrupt();
        thread2.interrupt();
        thread1.join();
        thread2.join();
    }

    private static void reentrant() throws InterruptedException {
        Thread thread1 = new Thread(() -> {

            try {
//                l1.lockInterruptibly();
                l1.lock();
                Thread.sleep(1000);
//                l2.lockInterruptibly();
                l2.lock();
            } catch (InterruptedException e) {
                System.out.println("l1 interrupted");
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
//                l2.lockInterruptibly();
                l2.lock();
                Thread.sleep(1000);
//                l1.lockInterruptibly();
                l1.lock();
            } catch (InterruptedException e) {
                System.out.println("t2 interrupted");
            }

        });
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        thread1.interrupt();
        thread2.interrupt();
        thread1.join();
        thread2.join();
    }

    private static void test() {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!Thread.interrupted()) {
                System.out.println(i++);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread.start();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
//        sync();
//        count();
        reentrant();
    }
}
