package leetcode._189;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 3);
        rotate(ints, 4);
        System.out.println(Arrays.toString(ints));
    }

    private void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int j = 0; j < k; j++) {
            int tmp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }
    }
}
