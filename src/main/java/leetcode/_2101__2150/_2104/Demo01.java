package leetcode._2101__2150._2104;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(subArrayRanges(new int[]{1, 2, 3}));
    }

    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i], min = max;
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }

}
