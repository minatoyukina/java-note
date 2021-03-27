package leetcode._1__50._31;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        int[] arr = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void nextPermutation(int[] nums) {
        int index = -1, right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (j > index) {
                        index = j;
                        right = i;
                        break;
                    }
                }
            }
        }
        if (index != -1) {
            int tmp = nums[index];
            nums[index] = nums[right];
            nums[right] = tmp;
        }
        Arrays.sort(nums, index + 1, nums.length);
    }

}