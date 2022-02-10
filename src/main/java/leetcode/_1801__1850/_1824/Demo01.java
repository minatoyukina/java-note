package leetcode._1801__1850._1824;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSideJumps(new int[]{0, 1, 2, 3, 0}));
        System.out.println(minSideJumps(new int[]{0, 1, 1, 3, 3, 0}));
        System.out.println(minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
    }

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[][] dp = new int[n + 1][3];
        dp[0][0] = dp[0][2] = 1;
        for (int i = 1; i <= n; i++) {
            if (obstacles[i] != 0) dp[i - 1][obstacles[i] - 1] = (int) 1e7;
            int min = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]));
            for (int j = 0; j < 3; j++) dp[i][j] = dp[i - 1][j] == min ? min : min + 1;
            if (obstacles[i] != 0) dp[i][obstacles[i] - 1] = (int) 1e7;

        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }

}