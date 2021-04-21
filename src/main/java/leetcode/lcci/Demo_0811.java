package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0811 {

    @Test
    public void test() {
        System.out.println(waysToChange(929782));
        System.out.println(waysToChange(5));
    }

    private int waysToChange(int n) {
        int[][] dp = new int[n + 1][4];
        int mod = 1000000007;
        for (int i = 0; i <= n; i++) {
            if (i >= 25)
                dp[i][3] = i == 25 ? 1 :
                        (dp[i - 25][3] % mod + dp[i - 25][2] % mod + dp[i - 25][1] % mod + dp[i - 25][0] % mod);
            if (i >= 10) dp[i][2] = i == 10 ? 1 : (dp[i - 10][2] % mod + dp[i - 10][1] % mod + dp[i - 10][0] % mod);
            if (i >= 5) dp[i][1] = i == 5 ? 1 : (dp[i - 5][1] % mod + dp[i - 5][0] % mod);
            if (i >= 1) dp[i][0] = 1;
        }
        int ans = 0;
        for (int i : dp[n]) ans += i % mod;
        return ans % mod;
    }
}
