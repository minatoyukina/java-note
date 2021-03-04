package leetcode._1631;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumEffortPath(new int[][]{
                new int[]{1, 2, 2},
                new int[]{3, 8, 2},
                new int[]{5, 3, 5},
        }));
        System.out.println(minimumEffortPath(new int[][]{
                new int[]{1, 10, 6, 7, 9, 10, 4, 9},
        }));

        System.out.println(minimumEffortPath(new int[][]{
                new int[]{1, 2, 1, 1, 1},
                new int[]{1, 2, 1, 2, 1},
                new int[]{1, 2, 1, 2, 1},
                new int[]{1, 2, 1, 2, 1},
                new int[]{1, 1, 1, 2, 1},

        }));
    }

    private int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0) {
                    int ph = Math.max(dp[i - 1][j], Math.abs(heights[i][j] - heights[i - 1][j]));
                    int nh = Math.max(dp[i + 1][j], Math.abs(heights[i][j] - heights[i + 1][j]));
                    int pv = Math.max(dp[i][j - 1], Math.abs(heights[i][j] - heights[i][j - 1]));
                    int nv = Math.max(dp[i][j + 1], Math.abs(heights[i][j] - heights[i][j + 1]));
                    dp[i][j] = Math.min(Math.min(ph, nh), Math.min(pv, nv));
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
