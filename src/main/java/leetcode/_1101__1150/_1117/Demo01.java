package leetcode._1101__1150._1117;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class Demo01 {


    @Test
    public void test() {

    }

    @SuppressWarnings("all")
    class H2O {

        private Semaphore h = new Semaphore(0);
        private Semaphore o = new Semaphore(1);
        private int i = 0;

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            releaseHydrogen.run();
            i++;
            if (i % 3 == 0) o.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            releaseOxygen.run();
            i++;
            h.release(2);
        }
    }

}