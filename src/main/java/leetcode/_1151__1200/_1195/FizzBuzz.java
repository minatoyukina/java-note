package leetcode._1151__1200._1195;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> fizzBuzz.fizz(() -> System.out.println("fizz")));
        Thread t2 = new Thread(() -> fizzBuzz.buzz(() -> System.out.println("buzz")));
        Thread t3 = new Thread(() -> fizzBuzz.fizzbuzz(() -> System.out.println("fizzBuzz")));
        Thread t4 = new Thread(() -> fizzBuzz.number(System.out::println));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private int n;
    private int a = 1;
    private final ReentrantLock lock = new ReentrantLock();

    private FizzBuzz(int n) {
        this.n = n;
    }

    private void fizz(Runnable printFizz) {
        while (a <= n) {
            try {
                lock.lock();
                while (a % 3 == 0 && a % 5 != 0 && a <= n) {
                    printFizz.run();
                    a++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void buzz(Runnable printBuzz) {
        while (a <= n) {
            try {
                lock.lock();
                while (a % 5 == 0 && a % 3 != 0 && a <= n) {
                    printBuzz.run();
                    a++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void fizzbuzz(Runnable printFizzBuzz) {
        while (a <= n) {
            try {
                lock.lock();
                while (a % 15 == 0 && a <= n) {
                    printFizzBuzz.run();
                    a++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void number(IntConsumer printNumber) {
        while (a <= n) {
            try {
                lock.lock();
                while (a % 3 != 0 && a % 5 != 0 && a <= n) {
                    printNumber.accept(a);
                    a++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}