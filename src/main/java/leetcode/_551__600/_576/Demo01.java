package leetcode._551__600._576;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findPaths(8, 50, 23, 5, 26));
        System.out.println(findPaths(2, 2, 2, 0, 0));
        System.out.println(findPaths(1, 3, 3, 1, 1));
    }

    private int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m + 1][n + 1][maxMove + 1];
        for (int[][] ints : dp) for (int[] anInt : ints) Arrays.fill(anInt, -1);
        return dfs(m, n, maxMove, startRow, startColumn);
    }


    private static final int MOD = (int) (1e9 + 7);
    private int[][][] dp;

    private int dfs(int m, int n, int maxMove, int row, int col) {
        if (maxMove < 0) return 0;
        if (maxMove < row && maxMove < col && maxMove < m - row && maxMove < n - col) return 0;
        if (row < 0 || col < 0 || row >= m || col >= n) return 1;
        if (dp[row][col][maxMove] != -1) return dp[row][col][maxMove];
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i * j != 0 || (i == 0 && j == 0)) continue;
                sum += dfs(m, n, maxMove - 1, row + i, col + j);
                sum %= MOD;
            }
        }
        return dp[row][col][maxMove] = sum;
    }
}