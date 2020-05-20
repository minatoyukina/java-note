package leetcode._251__300._268;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    private int missingNumber(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[i] < nums.length) {
                    tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                    i--;
                } else {
                    tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

}
