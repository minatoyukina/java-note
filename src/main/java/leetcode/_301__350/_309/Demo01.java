package leetcode._301__350._309;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }

    private int maxProfit(int[] prices) {
        return dfs(prices, 0, false, 0);
    }

    private int dfs(int[] prices, int day, boolean bought, int buyPrice) {
        if (day >= prices.length) return 0;
        if (bought) {
            //sell
            int a = prices[day] - buyPrice + dfs(prices, day + 2, false, 0);
            //wait
            int b = dfs(prices, day + 1, true, buyPrice);
            return Math.max(a, b);
        } else {
            //wait
            int a = dfs(prices, day + 1, false, 0);
            //buy
            int b = dfs(prices, day + 1, true, prices[day]);
            return Math.max(a, b);
        }
    }
}