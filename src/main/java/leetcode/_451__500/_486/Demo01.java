package leetcode._451__500._486;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

    private boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int max = max(nums);
        return max >= sum - max;

    }

    private int max(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        for (int num : nums) sum += num;
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        System.arraycopy(nums, 0, arr1, 0, nums.length - 1);
        System.arraycopy(nums, 1, arr2, 0, nums.length - 1);
        return Math.max(sum - max(arr1), sum - max(arr2));
    }

}