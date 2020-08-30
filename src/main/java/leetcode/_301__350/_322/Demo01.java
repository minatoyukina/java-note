package leetcode._301__350._322;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{1, 7, 12}, 14));
        System.out.println(coinChange(new int[]{1}, 0));

    }

    private int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1)
                    min = Math.min(min, dp[i - coin] + 1);
            }
            if (dp[i] != 1)
                dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
