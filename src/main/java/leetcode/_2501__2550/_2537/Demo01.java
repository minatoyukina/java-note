package leetcode._2501__2550._2537;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countGood(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }

    public long countGood(int[] nums, int k) {
        long ans = 0, sum = 0;
        int left = 0, right = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (left < n && right < n) {
            sum += map.getOrDefault(nums[right], 0);
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (sum >= k) ans += left + 1;
            while (sum + 1 - map.get(nums[left]) >= k) {
                ans++;
                int v = map.get(nums[left]);
                sum -= v - 1;
                if (v == 1) map.remove(nums[left]);
                else map.put(nums[left], v - 1);
                left++;

            }
            right++;
        }
        return ans;
    }

}