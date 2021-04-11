package leetcode._1101__1150._1116;

import org.junit.Test;

import java.util.function.IntConsumer;

public class Demo01 {


    @Test
    public void test() throws InterruptedException {
        ZeroEvenOdd test = new ZeroEvenOdd(51);
        Thread t1 = new Thread(() -> {
            try {
                test.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                test.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                test.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    @SuppressWarnings("all")
    class ZeroEvenOdd {
        private int n;
        private final Object object = new Object();
        private int i = 0;
        private boolean b = true;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (i < n) {
                synchronized (object) {
                    if (i < n && b) {
                        printNumber.accept(0);
                        b = false;
                        notifyAll();
                    } else wait();
                }
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (i < n) {
                synchronized (object) {
                    if (i < n && !b && i % 2 == 1) {
                        printNumber.accept(++i);
                        b = true;
                        notifyAll();
                    } else wait();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (i < n) {
                synchronized (object) {
                    if (i < n && !b && i % 2 == 0) {
                        printNumber.accept(++i);
                        b = true;
                        notifyAll();
                    } else wait();
                }
            }
        }
    }
}
