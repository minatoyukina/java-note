package leetcode._301__350._312;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(maxCoins(new int[]{9, 76}));
        System.out.println(maxCoins(new int[]{2, 3, 7, 9, 1, 8, 2}));
    }

    private int[][] rec;

    private int maxCoins(int[] nums) {
        rec = new int[nums.length + 2][nums.length + 2];
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[nums.length + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        return dac(arr, 0, rec.length - 1);
    }

    private int dac(int[] nums, int left, int right) {
        if (left >= right - 1) return 0;
        if (rec[left][right] != 0) return rec[left][right];
        for (int i = left + 1; i < right; i++) {
            int sum = nums[left] * nums[i] * nums[right] + dac(nums, left, i) + dac(nums, i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }
}