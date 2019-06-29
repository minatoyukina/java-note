package design_pattern.red_write_lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;

public class Reader implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    private Lock readLock;
    private String name;

    Reader(String name, Lock readLock) {
        this.readLock = readLock;
        this.name = name;
    }

    @Override
    public void run() {
        readLock.lock();
        try {
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    private void read() throws InterruptedException {
        LOGGER.info("{} begin", name);
        Thread.sleep(250);
        LOGGER.info("{} finish", name);
    }
}
