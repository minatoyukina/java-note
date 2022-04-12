package leetcode._1551__1600._1577;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numTriplets(new int[]{3, 1, 2, 2}, new int[]{1, 3, 4, 4}));
        System.out.println(numTriplets(new int[]{1, 1}, new int[]{1, 1, 1}));
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    private int helper(int[] nums1, int[] nums2) {
        int count = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (long i : nums1) map.put(i * i, map.getOrDefault(i * i, 0) + 1);
        for (int i = 0; i < nums2.length; i++)
            for (int j = i + 1; j < nums2.length; j++)
                count += map.getOrDefault((long) nums2[i] * nums2[j], 0);
        return count;
    }
}