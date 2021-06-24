package leetcode.lcof;

import org.junit.Test;

import java.util.Arrays;

public class Demo21 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4, 5})));

    }

    private int[] exchange(int[] nums) {
        int odd = 0, even = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (even == odd) break;
            if (nums[i] % 2 == 0) {
                if (i == even) continue;
                int t = nums[i];
                nums[i] = nums[even];
                nums[even--] = t;
            } else {
                if (i == odd) continue;
                int t = nums[i];
                nums[i] = nums[odd];
                nums[odd++] = t;
            }
            i--;
        }
        return nums;
    }

}
