package design_pattern.singleton;

public class Lazy {
    private static Lazy lazy;

    private Lazy() {
    }

    public static Lazy getInstance() {
        if (lazy == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazy = new Lazy();
        }
        return lazy;
    }
}
