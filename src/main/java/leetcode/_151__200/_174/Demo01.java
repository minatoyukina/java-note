package leetcode._151__200._174;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(calculateMinimumHP(new int[][]{
                {100},
        }));
        System.out.println(calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        }));
    }

    private int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) dp[i][j] = dungeon[i][j] <= 0 ? -dungeon[i][j] : 0;
                else {
                    if (i == m - 1) dp[i][j] = dungeon[i][j] > dp[i][j + 1] ? 0 : (dp[i][j + 1] - dungeon[i][j]);
                    else if (j == n - 1) dp[i][j] = dungeon[i][j] > dp[i + 1][j] ? 0 : (dp[i + 1][j] - dungeon[i][j]);
                    else {
                        int x = dungeon[i][j] > dp[i][j + 1] ? 0 : (dp[i][j + 1] - dungeon[i][j]);
                        int y = dungeon[i][j] > dp[i + 1][j] ? 0 : (dp[i + 1][j] - dungeon[i][j]);
                        dp[i][j] = Math.min(x, y);
                    }
                }
                if (dp[i][j] + dungeon[i][j] == 0) dp[i][j]++;
            }
        }
        return dp[0][0] == 0 ? 1 : dp[0][0];
    }

}