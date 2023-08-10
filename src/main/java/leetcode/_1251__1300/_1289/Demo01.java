package leetcode._1251__1300._1289;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minFallingPathSum(Common.strToArray("[[7]]")));
        System.out.println(minFallingPathSum(Common.strToArray("[" +
                "[-73,61,43,-48,-36]," +
                "[3,30,27,57,10]," +
                "[96,-76,84,59,-15]," +
                "[5,-49,76,31,-7]," +
                "[97,91,61,-46,67]]")));
    }

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] ints : dp) Arrays.fill(ints, min);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = grid[i][j];
                else for (int k = 0; k < n; k++) if (j != k) dp[i][j] = Math.min(dp[i - 1][k] + grid[i][j], dp[i][j]);
                if (i == n - 1) min = Math.min(dp[i][j], min);
            }
        }
        return min;
    }

}