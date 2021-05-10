package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1011 {

    @Test
    public void test() {
        int[] ints = {5, 3, 1, 2, 4};
        wiggleSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int n = copy.length / 2;
        int left = 0, right = nums.length - 1;
        int x = 0;
        while (n-- > 0) {
            nums[x++] = copy[right--];
            nums[x++] = copy[left++];
        }
        if (nums.length % 2 == 1) nums[nums.length - 1] = copy[nums.length / 2];
    }
}
