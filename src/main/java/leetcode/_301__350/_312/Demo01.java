package leetcode._301__350._312;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{2, 3, 7, 9, 1, 8, 2}));
    }

    private int maxCoins(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = i - 1 < 0 ? 1 : nums[i - 1];
            int y = i + 1 >= nums.length ? 1 : nums[i + 1];
            int[] arr = new int[nums.length - 1];
            int offset = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) arr[offset++] = nums[j];
            }
            max = Math.max(max, x * y * nums[i] + maxCoins(arr));
        }
        return max;
    }
}