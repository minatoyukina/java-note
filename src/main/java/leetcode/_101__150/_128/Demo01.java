package leetcode._101__150._128;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 0, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                ans = Math.max(ans, count);
                count = 1;
            }
            if (nums[i + 1] - nums[i] == 1) count++;
        }
        return Math.max(ans, count);
    }

}