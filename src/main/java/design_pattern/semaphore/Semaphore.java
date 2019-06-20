package design_pattern.semaphore;

public class Semaphore implements Lock {
    private final int licenses;
    private int counter;

    Semaphore(int licenses) {
        this.licenses = licenses;
        this.counter = licenses;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        while (counter == 0)
            wait();
        counter = counter - 1;
    }

    @Override
    public synchronized void release() {
        if (counter < licenses) {
            counter = counter + 1;
            notify();
        }
    }
}

