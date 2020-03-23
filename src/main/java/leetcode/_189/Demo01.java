package leetcode._189;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }

    private void rotate(int[] nums, int k) {
        for (int i = 0; i <= k - 1; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - k + i];
            nums[k + i] = tmp;
        }
    }
}
