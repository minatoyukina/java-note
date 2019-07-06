package concurrent.abc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCLock {
    private static Lock lock = new ReentrantLock();
    private static int count = 1;


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 3 == 1) {
                        System.out.println(count + Thread.currentThread().getName());
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 3 == 2) {
                        System.out.println(count + Thread.currentThread().getName());
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 3 == 0) {
                        System.out.println(count + Thread.currentThread().getName());
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "C").start();
    }
}
