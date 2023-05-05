package leetcode._2201__2250._2226;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maximumCandies(new int[]{1, 2, 3, 4, 10}, 5));
        System.out.println(maximumCandies(new int[]{4, 7, 5}, 4));
    }

    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long left = 1, right = candies[candies.length - 1];
        if (k > Arrays.stream(candies).mapToLong(x -> x).sum()) return 0;
        while (left < right) {
            long mid = (left + right) / 2;
            if (check(mid, candies, k)) left = mid + 1;
            else right = mid;
        }
        return (int) (left) - 1;
    }

    private boolean check(long target, int[] candies, long k) {
        for (int i = candies.length - 1; i >= 0; i--) {
            int candy = candies[i];
            k -= candy / target;
            if (k <= 0 || candy < target) break;
        }
        return k <= 0;
    }

}
