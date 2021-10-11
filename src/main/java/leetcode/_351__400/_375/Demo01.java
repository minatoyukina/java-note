package leetcode._351__400._375;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(getMoneyAmount(10));
    }

    public int getMoneyAmount(int n) {
        dp = new int[n + 2][n + 2];
        return dfs(1, n);
    }

    private int[][] dp;

    private int dfs(int left, int right) {
        if (dp[left][right] != 0) return dp[left][right];
        if (left >= right) return 0;
        if (right - left == 1) return left;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, i + Math.max(dfs(left, i - 1), dfs(i + 1, right)));
        }
        return dp[left][right] = min;
    }

}