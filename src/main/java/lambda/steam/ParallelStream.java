package lambda.steam;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {
    private static long measureSum(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + duration);
            if (duration < fastest)
                fastest = duration;
        }
        return fastest;
    }

    private static long iterativeSum(long n) {
        long sum = 0;
        for (long i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    private static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    private static long rangedSUm(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(measureSum(ParallelStream::parallelSum, 10_000_000));
        System.out.println(measureSum(ParallelStream::iterativeSum, 10_000_000));
        System.out.println(measureSum(ParallelStream::rangedSUm, 10_000_000));
    }
}
