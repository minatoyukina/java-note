package crawler.yandere;

import java.util.concurrent.*;

public class PCMain {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        Producer p1 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        Consumer c4 = new Consumer(queue);
        Consumer c5 = new Consumer(queue);
        p1.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
