package leetcode._51__100._80;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 1}));
    }

    @SuppressWarnings("all")
    private int removeDuplicates(int[] nums) {
        int res = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] != nums[j]) break;
                if (j - 1 >= 0 && nums[j - 1] == nums[i]) count++;
                if ((j - 1 >= 0 && nums[j - 1] != nums[i]) || j == 0) {
                    i = j;
                    for (int k = j + 2; k < nums.length - count; k++) {
                        nums[k] = nums[k + count];
                    }
                }
            }
            res -= count;
        }
        return res;
    }
}
