package leetcode._2001__2050._2001;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(interchangeableRectangles(Common.strToArray("[[4,8],[3,6],[10,20],[15,30]]")));
    }

    public long interchangeableRectangles(int[][] rectangles) {
        return Arrays.stream(rectangles).collect(Collectors.groupingBy(x -> {
            int gcd = gcd(x[0], x[1]);
            return x[0] / gcd * (int) 1e5 + x[1] / gcd;
        }, Collectors.counting())).values().stream().map(x -> x * (x - 1) / 2).reduce(0L, Long::sum);
    }

    private static int gcd(int m, int n) {
        while (n != 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

}
