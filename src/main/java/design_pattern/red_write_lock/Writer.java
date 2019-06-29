package design_pattern.red_write_lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;

public class Writer implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);

    private Lock writeLock;
    private String name;

    Writer(String name, Lock writeLock) {
        this.writeLock = writeLock;
        this.name = name;
    }

    @Override
    public void run() {
        writeLock.lock();
        try {
            write();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    private void write() throws InterruptedException {
        LOGGER.info("{} begin", name);
        Thread.sleep(250);
        LOGGER.info("{} finish", name);
    }
}
