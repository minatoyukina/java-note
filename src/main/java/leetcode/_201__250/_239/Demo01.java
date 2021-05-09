package leetcode._201__250._239;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
    }

    private int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            ans[i] = map.lastKey();
            Integer left = map.get(nums[i]);
            if (left != null) {
                if (left == 1) map.remove(nums[i]);
                else map.put(nums[i], left - 1);
            }
            if (i + k < nums.length) map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1);
        }
        return ans;
    }

}