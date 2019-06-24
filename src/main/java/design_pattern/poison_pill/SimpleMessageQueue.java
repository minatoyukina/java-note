package design_pattern.poison_pill;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleMessageQueue implements MessageQueue {
    private final BlockingQueue<Message> queue;

    SimpleMessageQueue(int bound) {
        queue = new ArrayBlockingQueue<>(bound);
    }

    @Override
    public void put(Message msg) throws InterruptedException {
        queue.put(msg);
    }

    @Override
    public Message take() throws InterruptedException {
        return queue.take();
    }
}
