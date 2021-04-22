package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1719 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(missingTwo(new int[]{1, 3, 4, 5, 6, 7, 8, 10})));
        System.out.println(Arrays.toString(missingTwo(new int[]{2, 3})));
    }

    private int[] missingTwo(int[] nums) {
        int sum = 0;
        int n = nums.length + 2;
        for (int num : nums) sum += num;
        int anb = (1 + n) * n / 2 - sum;
        int half = anb / 2;
        sum = (1 + half) * half / 2;
        for (int num : nums) if (num <= half) sum -= num;
        return new int[]{sum, anb - sum};
    }
}
