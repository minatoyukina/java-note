package design_pattern.singleton;

public class ThreadSafeDoubleCheckLocking {
    private static volatile ThreadSafeDoubleCheckLocking instance;

    private ThreadSafeDoubleCheckLocking() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static ThreadSafeDoubleCheckLocking getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                if (instance == null) {
                    instance = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return instance;
    }
}
