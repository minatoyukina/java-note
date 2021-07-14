package leetcode._1001__1050._1014;

import org.junit.Test;

public class Demo03 {


    @Test
    public void test() {
        System.out.println(maxScoreSightseeingPair(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    private int maxScoreSightseeingPair(int[] values) {
        int max = 0, ans = 0;
        for (int i = 0; i < values.length; i++) {
            ans = Math.max(ans, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }

}