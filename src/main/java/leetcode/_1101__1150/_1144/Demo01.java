package leetcode._1101__1150._1144;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(movesToMakeZigzag(new int[]{3, 10, 7, 9, 9, 3, 6, 9, 4}));
    }

    private int movesToMakeZigzag(int[] nums) {
        int s2 = dfs(nums, 0, false);
        int s4 = dfs(nums, 1, false);
        return Math.min(s2, s4);
    }

    private int dfs(int[] nums, int pos, boolean peek) {
        if (pos >= nums.length) return 0;
        int left = peek ? -1 : 10000, right = left, mid = nums[pos];
        if (pos - 1 >= 0) left = nums[pos - 1];
        if (pos + 1 < nums.length) right = nums[pos + 1];
        if (peek) {
            if (mid <= left || mid <= right) return Math.max(left, right) - mid + 1 + dfs(nums, pos + 2, true);
        } else {
            if (mid >= left || mid >= right) return mid - Math.min(left, right) + 1 + dfs(nums, pos + 2, false);
        }
        return dfs(nums, pos + 2, peek);
    }


}