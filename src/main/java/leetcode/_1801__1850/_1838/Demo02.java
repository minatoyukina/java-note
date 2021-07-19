package leetcode._1801__1850._1838;

import org.junit.Test;

import java.util.Arrays;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));
    }

    private int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int right = nums.length - 1, left = right;
        int max = 1, count = 0;
        while (right >= 0 && left >= 0) {
            int dlt = nums[right] - nums[left];
            if (k - dlt >= 0) {
                count++;
                k -= dlt;
                left--;
            } else {
                max = Math.max(max, count--);
                right--;
                if (right >= 0) k += count * (nums[right + 1] - nums[right]);
            }
        }
        return Math.max(max, count);
    }

}