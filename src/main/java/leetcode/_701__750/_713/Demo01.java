package leetcode._701__750._713;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    private int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, left = 0, right = 0, prod = 1;
        while (right < nums.length) {
            prod *= nums[right];
            while (left <= right && prod >= k) prod /= nums[left++];
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

}