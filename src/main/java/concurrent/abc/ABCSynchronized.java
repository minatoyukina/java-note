package concurrent.abc;

public class ABCSynchronized {
    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (count < 99) {
                    while (count % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(count++ + Thread.currentThread().getName());
                    lock.notifyAll();
                }
            }
        }, "A").start();
        new Thread(() -> {
            synchronized (lock) {
                while (count < 99) {
                    while (count % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(count++ + Thread.currentThread().getName());
                    lock.notifyAll();
                }
            }
        }, "B").start();
        new Thread(() -> {
            synchronized (lock) {
                while (count < 99) {
                    while (count % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(count++ + Thread.currentThread().getName());
                    lock.notifyAll();
                }
            }
        }, "C").start();
    }
}
