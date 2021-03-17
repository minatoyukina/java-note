package leetcode._251__300._264;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(1600));
        System.out.println(nthUglyNumber(1690));
    }

    private int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] arr = {2, 3, 5};
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                for (int a : arr) {
                    if (dp[j] * (long) a > dp[i - 1]) {
                        min = Math.min(min, dp[j] * (long) a);
                    }
                }
            }
            dp[i] = (int) min;
        }
        return dp[n - 1];
    }

}
