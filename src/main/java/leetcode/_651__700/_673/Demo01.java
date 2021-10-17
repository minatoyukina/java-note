package leetcode._651__700._673;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    private int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        count[0] = 1;
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] == 1) count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == max) ans += count[i];
        }
        return ans;
    }


}