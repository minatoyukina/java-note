package design_pattern.semaphore;

public interface Lock {
    void acquire() throws InterruptedException;

    void release();
}
