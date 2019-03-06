package jvm;

public class StackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    private void stackLeakByThread() {
        while (true) {
            new Thread(this::dontStop).start();

        }
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        oom.stackLeakByThread();
    }
}
