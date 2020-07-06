package leetcode._551__600._593;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(validSquare(
                new int[]{1, 1},
                new int[]{5, 3},
                new int[]{3, 5},
                new int[]{7, 7}
        ));
    }

    private boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] x = new int[]{p1[0], p2[0], p3[0], p4[0]};
        int[] y = new int[]{p1[1], p2[1], p3[1], p4[1]};
        Arrays.sort(x);
        Arrays.sort(y);
        Set<Integer> set = new HashSet<>(Arrays.asList(x[0], y[0], x[3], y[3]));
        if (!set.contains(p1[0]) && !set.contains(p1[1])) return false;
        if (!set.contains(p2[0]) && !set.contains(p2[1])) return false;
        if (!set.contains(p3[0]) && !set.contains(p3[1])) return false;
        int a = x[1] - x[0], b = x[3] - x[1], c = x[2] - x[0], d = x[3] - x[2];
        int h = y[1] - y[0], i = y[3] - y[1], j = y[2] - y[0], k = y[3] - y[2];
        return a + b > 0 && a == h && a == d && a == k
                && b == i && b == c && b == j;
    }

}
