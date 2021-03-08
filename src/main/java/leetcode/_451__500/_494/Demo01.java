package leetcode._451__500._494;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 5));
    }

    private int findTargetSumWays(int[] nums, int S) {
        return back(nums, S, nums.length - 1);
    }

    private int back(int[] nums, int s, int offset) {
        if (offset == 0) {
            if (nums[0] == 0 && s == 0) return 2;
            return (s == nums[0] || s == -nums[0]) ? 1 : 0;
        }
        int num = nums[offset];
        return back(nums, s - num, offset - 1) + back(nums, s + num, offset - 1);
    }

}
