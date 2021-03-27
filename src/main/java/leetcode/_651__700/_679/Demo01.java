package leetcode._651__700._679;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(judgePoint24(new int[]{3, 4, 6, 7}));
        System.out.println(judgePoint24(new int[]{1, 9, 1, 2}));
    }

    private boolean judgePoint24(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int[] copy = new int[nums.length - 1];
            int offset = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) copy[offset++] = nums[j];
            }
            if (dfs(nums[i], 1, copy)) return true;
        }
        return false;
    }

    private boolean dfs(int up, int down, int[] nums) {
        if (nums.length == 0) {
            if (down != 0 && up % down == 0 && up / down == 24) {
                return true;
            }
        }
        if (nums.length == 2) {
            if (dfs(up, down, new int[]{nums[0] + nums[1]})) return true;
            if (dfs(up, down, new int[]{nums[0] - nums[1]})) return true;
            if (dfs(up, down, new int[]{nums[0] * nums[1]})) return true;
            int uPlus = up * nums[1] + down * nums[0];
            int uMinus = up * nums[1] - down * nums[0];
            int d = down * nums[1];
            if (d != 0) {
                if (uPlus % d == 0 && uPlus / d == 24) return true;
                if (uMinus % d == 0 && uMinus / d == 24) return true;
                if (up * nums[0] % d == 0 && up * nums[0] / d == 24) return true;
            }
            if (down * nums[0] != 0) {
                if (up * nums[1] % (down * nums[0]) == 0 && up * nums[1] / (down * nums[0]) == 24) return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int[] copy = new int[nums.length - 1];
            int offset = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) copy[offset++] = nums[j];
            }
            if (dfs(up + down * nums[i], down, copy)) return true;

            if (dfs(up - down * nums[i], down, copy)) return true;
            if (dfs(down * nums[i] - up, down, copy)) return true;

            if (dfs(up * nums[i], down, copy)) return true;
            if (dfs(up, down * nums[i], copy)) return true;

            if (dfs(down * nums[i], up, copy)) return true;
        }
        return false;
    }

}