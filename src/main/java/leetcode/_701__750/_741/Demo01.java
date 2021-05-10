package leetcode._701__750._741;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(cherryPickup(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1},
        }));
    }

    private int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) dp[i + 1][j + 1] = -1;
                else {
                    int max = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    if (max < 0) dp[i + 1][j + 1] = -1;
                    else dp[i + 1][j + 1] = max + grid[i][j];
                }
            }
        }
        return dp[n][n];
    }

}