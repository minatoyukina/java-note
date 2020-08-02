package leetcode._401__450._416;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 5, 4, 2, 3, 6}));
        System.out.println(canPartition(new int[]{1, 5}));
    }

    private boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        else sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][sum];
    }

}
