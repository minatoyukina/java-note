package leetcode._501__550._518;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change(10, new int[]{1, 2, 5}));

    }

    private int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
