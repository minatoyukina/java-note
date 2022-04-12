package leetcode._1651__1700._1690;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }

    public int stoneGameVII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int l = stones.length;
        dp = new int[l][l];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(0, l - 1, sum, stones);
    }

    private int[][] dp;

    private int dfs(int left, int right, int sum, int[] stones) {
        if (dp[left][right] != -1) return dp[left][right];
        if (left == right) return 0;
        int x = sum - stones[left], y = sum - stones[right];
        return dp[left][right] = Math.max(x - dfs(left + 1, right, x, stones), y - dfs(left, right - 1, y, stones));
    }

}