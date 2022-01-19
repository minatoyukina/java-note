package leetcode._1951__2000._1981;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimizeTheDifference(new int[][]{
                {10, 3, 7, 7, 9, 6, 9, 8, 9, 5},
                {1, 1, 6, 8, 6, 7, 7, 9, 3, 9},
                {3, 4, 4, 1, 3, 6, 3, 3, 9, 9},
                {6, 9, 9, 3, 8, 7, 9, 6, 10, 6}
        }, 5));
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        dp = new int[mat.length][target + 1];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        for (int[] ints : mat) Arrays.sort(ints);
        return dfs(0, target, mat);
    }

    private int[][] dp;

    private int dfs(int row, int target, int[][] mat) {
        if (row >= mat.length) return Math.abs(target);
        if (target >= 0 && dp[row][target] != -1) return dp[row][target];
        int min = Integer.MAX_VALUE;
        for (int num : mat[row]) {
            min = Math.min(min, dfs(row + 1, target - num, mat));
            if (target < 0) break;
        }
        if (target >= 0) dp[row][target] = min;
        return min;
    }


}