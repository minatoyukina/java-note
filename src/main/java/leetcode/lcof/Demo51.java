package leetcode.lcof;

import org.junit.Test;

public class Demo51 {

    @Test
    public void test() {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }

    private int reversePairs(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i : dp) ans += i;
        return ans;
    }
}
