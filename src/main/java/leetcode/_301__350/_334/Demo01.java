package leetcode._301__350._334;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(increasingTriplet(new int[]{5}));
        System.out.println(increasingTriplet(new int[]{0, 10, 0, 0, 0, 0, 0, 0, 0, 100000000}));
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    private boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int left = 0, right = 1;
        boolean two = false;
        int tmp = nums[right];
        while (right < nums.length) {
            if (nums[right] > nums[left]) {
                if (nums[right] > tmp && two) return true;
                tmp = nums[right];
                two = true;
            } else if (!two || (right + 1 < nums.length && nums[right + 1] > nums[right])) left = right;
            right++;
        }
        return false;
    }

}