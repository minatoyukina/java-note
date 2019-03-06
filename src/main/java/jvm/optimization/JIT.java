package jvm.optimization;

public class JIT {
    private static final int NUM = 15000;

    private static int doubleValue(int i) {
        return i * 2;
    }

    private static long calcSum() {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }

}
