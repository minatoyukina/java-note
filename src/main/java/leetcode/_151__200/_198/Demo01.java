package leetcode._151__200._198;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1,10}));
    }

    private int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        if (length == 4) return Math.max(Math.max(nums[0] + nums[2], nums[1] + nums[3]), nums[0] + nums[3]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        dp[3] = Math.max(nums[1] + nums[3], nums[0] + nums[3]);
        for (int i = 4; i < length; i++) {
            int a = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            int b = Math.max(dp[i - 3], dp[i - 4]) + nums[i - 1];
            dp[i] = Math.max(a, b);
        }
        return dp[length - 1];
    }
}
