package callback;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SimpleCallback {
    private void test(int x, CallBack callBack) {
        new Thread(() -> callBack.accept(x)).start();
    }

    private void consume(int x, Consumer<Integer> callBack) {
        new Thread(() -> callBack.accept(x)).start();
    }

    private boolean predicate(int x, Predicate<Integer> predicate) {
        return predicate.test(x);
    }

    private int supply(int x, Supplier<Integer> supplier) {
        return supplier.get();
    }

    private int function(int x, Function<Integer, Integer> function) {
        return function.apply(x);
    }

    public static void main(String[] args) {
        SimpleCallback simpleCallback = new SimpleCallback();
        int a = 4;
        simpleCallback.test(a, x -> System.out.println(x + 1));
        simpleCallback.consume(a, x -> System.out.println(x + 1));
        System.out.println(simpleCallback.predicate(a, x -> a % 2 == 1));
        System.out.println(simpleCallback.supply(a, () -> a + 1));
        System.out.println(simpleCallback.function(a, (x) -> x + 1));
        System.out.println(a);
    }

    @FunctionalInterface
    interface CallBack {
        void accept(int x);
    }
}
