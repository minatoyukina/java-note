package leetcode._451__500._457;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(circularArrayLoop(new int[]{-2, -3, -9}));
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
    }

    private boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) if (dfs(nums, i, 0)) return true;
        return false;
    }

    private boolean dfs(int[] nums, int index, int count) {
        if (count > nums.length) return true;
        int next = index + nums[index];
        next = Math.floorMod(next, nums.length);
        if (nums[next] * nums[index] < 0 || index == next) return false;
        return dfs(nums, next, ++count);
    }

}