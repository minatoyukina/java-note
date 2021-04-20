package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0801 {

    @Test
    public void test() {
        System.out.println(waysToStep(76));
        System.out.println(waysToStep(900750));
    }

    private int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int x = 1000000007;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] % x + dp[i - 2] % x + dp[i - 1] % x;
        }
        return (int) (dp[n] % x);
    }
}
