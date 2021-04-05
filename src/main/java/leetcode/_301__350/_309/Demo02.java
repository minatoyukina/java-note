package leetcode._301__350._309;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    private int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] boughtWait = new int[prices.length];
        int[] moneyWait = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buy[i] = -prices[i];
                boughtWait[i] = -prices[i];
            } else {
                boughtWait[i] = Math.max(boughtWait[i - 1], buy[i - 1]);
                moneyWait[i] = Math.max(moneyWait[i - 1], sell[i - 1]);
                sell[i] = Math.max(buy[i - 1], boughtWait[i - 1]) + prices[i];
                buy[i] = Math.max(i == 1 ? 0 : sell[i - 2], moneyWait[i - 1]) - prices[i];
            }
        }
        int max = Math.max(sell[prices.length - 1], moneyWait[prices.length - 1]);
        return max < 0 ? 0 : max;
    }


}