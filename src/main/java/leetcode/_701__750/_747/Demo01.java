package leetcode._701__750._747;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(dominantIndex(new int[]{1, 0}));
    }

    private int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int first, second;
        if (nums[1] > nums[0]) {
            first = 1;
            second = 0;
        } else {
            second = 1;
            first = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[first]) {
                second = first;
                first = i;
            }
            if (nums[i] < nums[first] && nums[i] > nums[second]) second = i;
        }
        if (nums[second] == 0 || nums[first] / nums[second] >= 2) return first;
        return -1;
    }

}
