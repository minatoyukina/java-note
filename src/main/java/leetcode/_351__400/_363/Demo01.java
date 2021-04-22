package leetcode._351__400._363;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxSumSubmatrix(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, -2, 3},
        }, 2));
        System.out.println(maxSumSubmatrix(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, -2, 3},
        }, 3));
    }

    private int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = i; x < m; x++) {
                    for (int y = j; y < n; y++) {
                        int sum = dp[x + 1][y + 1] + dp[i][j] - dp[i][y + 1] - dp[x + 1][j];
                        if (sum <= k) ans = Math.max(ans, sum);
                    }
                }
            }
        }
        return ans;
    }


}