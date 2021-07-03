package leetcode._101__150._123;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int buy1 = -prices[0];//只进行了一次买操作,存的就是买的啥
        int buy2 = -prices[0];//在一次交易后买了第二个
        int sell1 = 0;//一次交易完
        int sell2 = 0;//两次交易完
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            //一次交易完可以是之前就交易完或者是之前买的，现在卖出
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;

    }
}