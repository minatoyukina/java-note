package leetcode._1451__1500._1473;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minCost(new int[]{0, 0, 2, 3}, new int[][]{
                {5, 4, 1}, {1, 2, 1}, {4, 4, 2}, {5, 2, 5},
        }, 4, 3, 4));
        System.out.println(minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{
                {1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}
        }, 5, 2, 3));
    }

    private int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[m + 1][n + 1][m + 1];
        for (int[][] ints : dp) for (int[] anInt : ints) Arrays.fill(anInt, -2);
        return dfs(houses, cost, m, n, target, 0, 0, 0);
    }

    private int[][][] dp;

    private int dfs(int[] houses, int[][] cost, int m, int n, int target, int index, int lastColor, int count) {
        if (dp[index][lastColor][count] > -2) return dp[index][lastColor][count];
        int min = Integer.MAX_VALUE;
        if (count > target) return dp[index][lastColor][count] = -1;
        if (index >= m) {
            if (target == count) return dp[index][lastColor][count] = 0;
            else return dp[index][lastColor][count] = -1;
        }
        if (houses[index] > 0) {
            int colorCount = houses[index] == lastColor ? count : count + 1;
            int dfs = dfs(houses, cost, m, n, target, index + 1, houses[index], colorCount);
            if (dfs != -1) min = Math.min(min, dfs);
        } else {
            for (int i = 0; i < n; i++) {
                int currentCost = houses[index] == i + 1 ? 0 : cost[index][i];
                int colorCount = i + 1 == lastColor ? count : count + 1;
                int dfs = dfs(houses, cost, m, n, target, index + 1, i + 1, colorCount);
                if (dfs == -1) continue;
                min = Math.min(min, currentCost + dfs);
            }
        }
        return dp[index][lastColor][count] = min == Integer.MAX_VALUE ? -1 : min;
    }
}
