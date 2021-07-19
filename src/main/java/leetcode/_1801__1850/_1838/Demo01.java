package leetcode._1801__1850._1838;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));
    }

    private int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int t = k, max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                int dlt = nums[i] - nums[j];
                if (t - dlt >= 0) {
                    t -= dlt;
                    count++;
                } else break;
            }
            max = Math.max(max, count);
            t = k;
        }
        return max;
    }

}