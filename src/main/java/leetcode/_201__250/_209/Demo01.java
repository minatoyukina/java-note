package leetcode._201__250._209;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(9, new int[]{1, 9, 4}));
    }

    private int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + nums[i];
        }
        if (sum[nums.length - 1] < s) return 0;
        int ans = nums.length;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] >= s) {
                int tmp = i + 1;
                for (int j = 0; j < i; j++) {
                    sum[i] -= nums[j];
                    if (sum[i] >= s) tmp--;
                    else break;
                }
                ans = Math.min(ans, tmp);
            }
        }
        return ans;
    }
}
