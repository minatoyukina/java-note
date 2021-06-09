package leetcode._851__900._879;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
        System.out.println(profitableSchemes(5, 3, new int[]{2, 3}, new int[]{2, 3}));
    }

    private int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[minProfit + 1][n + 1][group.length + 1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(n, minProfit, group, profit, 0, 0, 0);
    }

    private int[][][] dp;

    private int dfs(int n, int minProfit, int[] group, int[] profits, int profit, int people, int index) {
        int key = profit >= minProfit ? minProfit : profit;
        if (people > n) return 0;
        if (index > group.length) return profit >= minProfit ? 1 : 0;
        if (dp[key][people][index] != -1) return dp[key][people][index];
        int ans = 0;
        for (int i = index; i <= group.length; i++) {
            ans += dfs(n, minProfit, group, profits,
                    profit + (i == profits.length ? 0 : profits[i]),
                    people + (i == group.length ? 0 : group[i]), i + 1);
            ans %= (int) (1e9 + 7);
        }
        return dp[key][people][index] = ans;
    }

}