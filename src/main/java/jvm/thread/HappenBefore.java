package jvm.thread;

public class HappenBefore {
    private volatile int value = 0;
//    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

        HappenBefore happenBefore = new HappenBefore();
        new Thread(() -> System.out.println(happenBefore.getValue())).start();
        new Thread(() -> happenBefore.setValue(1)).start();

    }
}
