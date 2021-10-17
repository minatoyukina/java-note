package leetcode._901__950._918;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxSubarraySumCircular(new int[]{-2}));
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}));
        System.out.println(maxSubarraySumCircular(new int[]{-5, 4, -6}));
        System.out.println(maxSubarraySumCircular(new int[]{3, 1, 3, 2, 6}));
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }

    private int maxSubarraySumCircular(int[] nums) {
        int[] pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) pre[i + 1] = pre[i] + nums[i];
        int max = 0, min = 0, ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, pre[i + 1] - min);
            max = i == 0 ? nums[0] : Math.max(max, pre[i + 1]);
            min = i == 0 ? nums[0] : Math.min(min, pre[i + 1]);
            ans = Math.max(ans, pre[nums.length] - pre[i + 1] + max);
        }
        return ans;
    }

}