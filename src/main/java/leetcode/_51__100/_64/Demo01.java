package leetcode._51__100._64;

import org.junit.Test;

public class Demo01 {


    @Test
    public void testCut() {
        System.out.println(minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1},
        }));
        System.out.println(minPathSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
        }));
    }

    private int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dp[i + 1][j + 1] = ((i == 0 || j == 0) ?
                        Math.max(dp[i][j + 1], dp[i + 1][j]) :
                        Math.min(dp[i][j + 1], dp[i + 1][j])) + grid[i][j];
            }
        }
        return dp[x][y];
    }
}
