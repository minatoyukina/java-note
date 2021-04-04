package leetcode._701__750._724;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pivotIndex(new int[]{}));
        System.out.println(pivotIndex(new int[]{1, 1, 1}));
    }

    private int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (sum - pre == pre - nums[i]) return i;
        }
        return -1;
    }

}
