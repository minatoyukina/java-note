package leetcode._601__650._650;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSteps(9));
        System.out.println(minSteps(8));
    }

    private int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }


}
