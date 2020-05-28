package leetcode._1111;

import java.util.concurrent.atomic.AtomicInteger;

public class FooBar {
    private int n;
    private AtomicInteger a;

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        Thread a = new Thread(() -> fooBar.foo(() -> System.out.print("foo")));
        Thread b = new Thread(() -> fooBar.bar(() -> System.out.print("bar")));
        a.start();
        b.start();
    }

    private FooBar(int n) {
        this.n = n;
        a = new AtomicInteger(0);
    }

    private void foo(Runnable printFoo) {
        while (a.get() < 2 * n) {
            if (a.get() % 2 == 0) {
                printFoo.run();
                a.incrementAndGet();
            }
            Thread.yield();
        }
    }

    private void bar(Runnable printBar) {
        while (a.get() < 2 * n) {
            if (a.get() % 2 == 1) {
                printBar.run();
                a.incrementAndGet();
            }
            Thread.yield();
        }
    }
}