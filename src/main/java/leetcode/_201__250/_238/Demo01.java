package leetcode._201__250._238;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1, 2, 3, 4})));
    }

    private int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int s = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) s *= nums[j];
            }
            ans[i] = s;
        }
        return ans;
    }

    private int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) left[i] = 1;
            else left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) right[i] = 1;
            else right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < left.length; i++) {
            left[i] *= right[i];
        }
        return left;
    }
}
