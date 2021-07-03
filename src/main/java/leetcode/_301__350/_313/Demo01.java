package leetcode._301__350._313;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(nthSuperUglyNumber(15, new int[]{3, 5, 7, 11, 19, 23, 29, 41, 43, 47}));
        System.out.println(nthSuperUglyNumber(13, new int[]{2, 7, 13, 19}));
    }

    private int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] count = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, dp[count[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < count.length; j++) {
                if (dp[count[j]] * primes[j] == min) count[j]++;
            }

        }
        return dp[n - 1];
    }

}