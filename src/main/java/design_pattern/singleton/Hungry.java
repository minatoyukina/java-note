package design_pattern.singleton;

public class Hungry {
    private static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return hungry;
    }
}
