package leetcode._1__50._45;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }


    private int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }
}
