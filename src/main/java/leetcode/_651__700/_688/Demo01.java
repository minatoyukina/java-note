package leetcode._651__700._688;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(knightProbability(3, 2, 0, 0));
        System.out.println(knightProbability(4, 3, 1, 1));
    }

    private double knightProbability(int n, int k, int row, int column) {
        dp = new double[n + 1][n + 1][k + 1];
        for (double[][] ints : dp) for (double[] anInt : ints) Arrays.fill(anInt, -1);
        return dfs(n, n, k, row, column, k);
    }

    private double[][][] dp;

    private double dfs(int m, int n, int move, int row, int col, int k) {
        if (move < 0 || row < 0 || col < 0 || row >= m || col >= n) return 0;
        if (move == 0) return 1 / Math.pow(8, k - move);
        if (dp[row][col][move] != -1) return dp[row][col][move];
        double sum = 0;
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i * j) == 2) sum += dfs(m, n, move - 1, row + i, col + j, k);
            }
        }
        return dp[row][col][move] = sum;
    }
}