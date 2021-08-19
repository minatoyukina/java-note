package leetcode._551__600._552;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkRecord(5));
    }

    public int checkRecord(int n) {
        int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n][5];
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;
        for (int i = 1; i < n; i++) {
            // P
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            // L
            dp[i][1] = i < 2 ? 3 : (dp[i - 2][0] + dp[i - 2][2] + dp[i - 1][0] + dp[i - 1][2]);
            // A
            dp[i][2] = dp[i - 1][3] + dp[i - 1][4];
            // NAP
            dp[i][3] = dp[i - 1][3] + dp[i - 1][4];
            // NAL
            dp[i][4] = i < 2 ? 2 : (dp[i - 1][3] + dp[i - 2][3]);
            for (int j = 0; j < 5; j++) dp[i][j] %= MOD;

        }
        return (int) ((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % MOD);
    }
}