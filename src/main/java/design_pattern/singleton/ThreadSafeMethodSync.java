package design_pattern.singleton;

public class ThreadSafeMethodSync {
    private static volatile ThreadSafeMethodSync instance;

    private ThreadSafeMethodSync() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static synchronized ThreadSafeMethodSync getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (instance == null) {
                instance = new ThreadSafeMethodSync();
            }
        }
        return instance;
    }
}
