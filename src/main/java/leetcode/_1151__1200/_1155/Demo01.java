package leetcode._1151__1200._1155;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n][target];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int x = 0; x < k && x < target; x++) dp[i][x] = 1;
                continue;
            }
            for (int j = 0; j < target; j++)
                for (int x = 1; x <= k; x++)
                    if (j >= x) {
                        dp[i][j] += dp[i - 1][j - x];
                        dp[i][j] %= (int) 1e9 + 7;
                    }
        }
        return dp[n - 1][target - 1];
    }


}