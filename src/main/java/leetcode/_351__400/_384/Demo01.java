package leetcode._351__400._384;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Demo01 {


    @Test
    public void test() {
        Solution solution = new Solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    static class Solution {

        private final int[] meta;

        public Solution(int[] nums) {
            meta = Arrays.copyOf(nums, nums.length);
        }

        public int[] reset() {
            return meta;
        }

        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();
            for (int i : meta) list.add(i);
            int[] nums = new int[meta.length];
            for (int j = 0; j < meta.length; j++) {
                int i = new Random().nextInt(list.size());
                nums[j] = list.get(i);
                list.remove((Integer) nums[j]);
            }
            return nums;
        }
    }

}