package leetcode._1401__1450._1438;

import org.junit.Test;

import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4));
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0, n = nums.length, ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (left < n && right < n) {
            if (!map.isEmpty() && (Math.abs(nums[right] - map.firstKey()) > limit || Math.abs(nums[right] - map.lastKey()) > limit)) {
                Integer integer = map.get(nums[left]);
                if (integer == 1) map.remove(nums[left]);
                else map.put(nums[left], integer - 1);
                left++;
            } else {
                ans = Math.max(ans, right - left + 1);
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                right++;
            }
        }
        return ans;
    }
}