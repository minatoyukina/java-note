package leetcode._1501__1550._1509;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}));
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) return 0;
        Arrays.sort(nums);
        int a = nums[n - 1] - nums[3];
        int b = nums[n - 2] - nums[2];
        int c = nums[n - 3] - nums[1];
        int d = nums[n - 4] - nums[0];
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

}