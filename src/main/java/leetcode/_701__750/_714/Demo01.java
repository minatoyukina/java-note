package leetcode._701__750._714;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 1));
    }

    private int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(prices, fee, 0, 0);
    }

    private int[][] dp;

    //0持币观望 1等待抛售
    private int dfs(int[] prices, int fee, int pos, int state) {
        if (pos >= prices.length) return 0;
        if (dp[pos][state] != -1) return dp[pos][state];
        int max = 0;
        if (state == 0) {
            int i = Math.max(dfs(prices, fee, pos + 1, 0), dfs(prices, fee, pos + 1, 1) - prices[pos]);
            max = Math.max(max, i);
        } else {
            int i = Math.max(dfs(prices, fee, pos + 1, 1), dfs(prices, fee, pos + 1, 0) + prices[pos] - fee);
            max = Math.max(max, i);
        }
        return dp[pos][state] = max;
    }

}