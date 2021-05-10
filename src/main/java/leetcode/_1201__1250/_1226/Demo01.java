package leetcode._1201__1250._1226;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class Demo01 {


    @Test
    public void test() {

    }

    class DiningPhilosophers {
        private Semaphore[] semaphores;
        private int[] arr;

        public DiningPhilosophers() {
            semaphores = new Semaphore[5];
            for (int i = 0; i < 5; i++) semaphores[i] = new Semaphore(i == 0 ? 2 : 0);
            arr = new int[5];
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            Semaphore semaphore = semaphores[philosopher];
            semaphore.acquire(1);
            if (semaphore.drainPermits() == 1) {
                int i = arr[philosopher];
                if (i == 0) {
                    pickLeftFork.run();
                    arr[philosopher]++;
                } else if (i == 1) {
                    pickRightFork.run();
                    arr[philosopher]++;
                } else {
                    eat.run();
                }
            } else {
                int i = arr[philosopher];
                if (i == 1) {
                    putLeftFork.run();
                    arr[philosopher]--;
                }
                if (i == 2) {
                    putLeftFork.run();
                    arr[philosopher]--;
                }
            }
        }
    }

}