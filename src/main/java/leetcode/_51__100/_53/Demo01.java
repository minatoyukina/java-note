package leetcode._51__100._53;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    private int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > ans) ans = sum;
        }
        return ans;
    }
}
