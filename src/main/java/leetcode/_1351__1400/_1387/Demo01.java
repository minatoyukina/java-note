package leetcode._1351__1400._1387;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(getKth(7, 11, 4));
    }

    public int getKth(int lo, int hi, int k) {
        return IntStream.rangeClosed(lo, hi).boxed().sorted(Comparator.comparing(this::dfs).thenComparingInt(y -> y)).limit(k).reduce((x, y) -> y).orElse(0);
    }

    int dfs(int x) {
        if (x == 1) return 0;
        if (x % 2 == 0) return 1 + dfs(x / 2);
        else return 1 + dfs(3 * x + 1);
    }
}