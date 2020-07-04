package leetcode._501__550._503;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    private int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        label:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    continue label;
                }
            }
            for (int k = 0; k <= i; k++) {
                if (nums[k] > nums[i]) {
                    ans[i] = nums[k];
                    continue label;
                }
                if (k == i) ans[i] = -1;
            }
        }
        return ans;
    }

}
