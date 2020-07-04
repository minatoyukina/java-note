package leetcode._351__400._376;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(wiggleMaxLength(new int[]{1, 2, 1, 2, 1, 2, 5, 4}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1, 3, 3, 3, 2, 2, 2}));
    }

    private int wiggleMaxLength(int[] nums) {
        int ans = 1;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                flag = nums[i] > nums[i - 1];
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && flag) {
                ans++;
                flag = false;
            }
            if (nums[i] < nums[i - 1] && !flag) {
                ans++;
                flag = true;
            }
        }
        return nums.length == 0 ? 0 : ans;
    }
}
