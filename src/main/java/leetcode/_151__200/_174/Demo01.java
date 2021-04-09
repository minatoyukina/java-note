package leetcode._151__200._174;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
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
                if (i == m - 1 && j == n - 1) dp[i][j] = dungeon[i][j] < 0 ? -dungeon[i][j] : 0;
                else {
                    for (int x = i + 1; x < m - 1; x++) {
                        dp[i][j] = Math.min(dp[i][j], dp[x][j] + (dungeon[i][j] < 0 ? -dungeon[i][j] : 0));
                    }
                    for (int x = j + 1; x < n - 1; x++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][x] + (dungeon[i][j] < 0 ? -dungeon[i][j] : 0));
                    }
                }
            }
        }
        return dp[0][0];
    }

}