package leetcode._451__500._456;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(find132pattern(new int[]{1, 0, 1, -4, -3}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
    }

    private boolean find132pattern(int[] nums) {
        int left = 0, right = 0;
        int high = nums[right];
        int stub = -1;
        while (right < nums.length) {
            if (nums[right] > nums[left] && nums[right] < high) return true;
            if (nums[right] >= nums[left]) {
                high = Math.max(high, nums[right]);
            } else {
                if (high <= nums[left]) {
                    left = right;
                    high = nums[left];
                } else if (stub == -1) stub = right;

            }
            right++;
            if (right == nums.length && stub != -1) {
                left = stub;
                right = stub;
                high = nums[left];
                stub = -1;
            }
        }
        return false;
    }

}