package leetcode._51__100._63;

import org.junit.Test;

public class Demo01 {


    @Test
    public void testCut() {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i + 1][j + 1] = 0;
                } else dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
                if (i == 0 && j == 0 && obstacleGrid[0][0] != 1) dp[1][1] = 1;
            }
        }
        return dp[m][n];
    }
}
