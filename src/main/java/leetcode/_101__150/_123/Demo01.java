package leetcode._101__150._123;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    private int maxProfit(int[] prices) {
        dp = new int[prices.length][4];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(prices, 0, 0);
    }

    private int[][] dp;

    private int dfs(int[] prices, int index, int phase) {
        if (phase % 2 == 0) while (index + 1 < prices.length && prices[index + 1] <= prices[index]) index++;
        else while (index + 1 < prices.length && prices[index + 1] >= prices[index]) index++;
        if (index >= prices.length || phase >= 4) return 0;
        if (dp[index][phase] >= 0) return dp[index][phase];
        int max = 0;
        for (int i = index; i < prices.length; i++) {
            max = Math.max(max, (phase % 2 == 0 ? -prices[i] : prices[i]) + dfs(prices, i, phase + 1));
        }
        return dp[index][phase] = max;
    }

}