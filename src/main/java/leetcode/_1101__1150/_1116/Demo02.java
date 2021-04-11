package leetcode._1101__1150._1116;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Demo02 {


    @Test
    public void test() throws InterruptedException {
        ZeroEvenOdd test = new ZeroEvenOdd(5);
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
        private Semaphore zS = new Semaphore(1);
        private Semaphore eS = new Semaphore(0);
        private Semaphore oS = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int j = 1; j <= n; j++) {
                zS.acquire();
                printNumber.accept(0);
                if (j % 2 == 0) {
                    eS.release();
                } else {
                    oS.release();
                }

            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int j = 2; j <= n; j = j + 2) {
                eS.acquire();
                printNumber.accept(j);
                zS.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int j = 1; j <= n; j = j + 2) {
                oS.acquire();
                printNumber.accept(j);
                zS.release();
            }
        }
    }
}
