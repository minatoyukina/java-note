package leetcode._25;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 5}, 7));
    }

    private int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

}
