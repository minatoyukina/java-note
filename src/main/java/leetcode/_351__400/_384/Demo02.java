package leetcode._351__400._384;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Demo02 {


    @Test
    public void test() {
        Solution solution = new Solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    static class Solution {

        private final int[] meta;
        private final int[] nums;

        public Solution(int[] nums) {
            meta = Arrays.copyOf(nums, nums.length);
            this.nums = nums;
        }

        public int[] reset() {
            return meta;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                int x = new Random().nextInt(nums.length);
                int tmp = nums[i];
                nums[i] = nums[x];
                nums[x] = tmp;
            }
            return nums;
        }
    }

}