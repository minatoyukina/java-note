package leetcode._651__700._674;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 7}));

    }

    private int findLengthOfLCIS(int[] nums) {
        int ans = 1, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] <= nums[i]) {
                ans = Math.max(ans, count);
                count = 1;
            } else count++;
        }
        return Math.max(ans, count);
    }
}
