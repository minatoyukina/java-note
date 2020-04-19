package leetcode._1__50._34;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{7, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
    }

    private int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int lo = 0, high = nums.length - 1;
        while (lo < high) {
            int middle = (lo + high) / 2;
            if (nums[middle] > target) high = middle - 1;
            else if (nums[middle] == target) {
                return boom(nums, middle, target);
            } else lo = middle + 1;
        }
        if (nums[lo] != target) return new int[]{-1, -1};
        return boom(nums, lo, target);
    }

    private int[] boom(int[] nums, int index, int target) {
        int i = index, j = index;
        while (true) {
            if (i > 0 && nums[i - 1] == target) i--;
            else if (j < nums.length - 1 && nums[j + 1] == target) j++;
            else break;
        }
        return new int[]{i, j};
    }
}
