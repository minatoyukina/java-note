package leetcode._1751__1800._1787;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(minChanges(new int[]{11, 20, 3, 18, 26, 30, 20, 7, 3, 0, 25, 9, 19, 21, 3, 23}, 5));
        System.out.println(minChanges(new int[]{1, 2, 0, 3, 0}, 1));
    }

    private int minChanges(int[] nums, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> sub = map.getOrDefault(i % k, new HashMap<>());
            sub.put(nums[i], sub.getOrDefault(nums[i], 0) + 1);
            map.put(i % k, sub);
        }
        int[] max = new int[k];
        Arrays.fill(max, -1);
        for (int i = 0; i < max.length; i++) {
            Map<Integer, Integer> sub = map.get(i);
            Integer m = sub.values().stream().max(Integer::compareTo).orElse(0);
            List<Integer> collect = sub.entrySet().stream().filter(s -> s.getValue().equals(m)).map(Map.Entry::getKey).collect(Collectors.toList());
            if (collect.size() == 1) max[i] = collect.get(0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i ++) {
            int tot = 0;
            int[] arr = new int[k];
            for (int j = i; j < i + k; j++) {
                tot ^= nums[j];
                arr[j - i] = nums[j];
                if (max[j - i] != -1) arr[j - i] = max[j - i];
            }
            if (tot == 0) {
                ans = Math.min(ans, helper(nums, arr));
            } else {
                for (int j = 0; j < arr.length; j++) {
                    int tmp = arr[j];
                    arr[j] = tot ^ arr[j];
                    ans = Math.min(ans, helper(nums, arr));
                    arr[j] = tmp;
                }
            }
        }
        return ans;
    }

    @SuppressWarnings("all")
    private int helper(int[] nums, int[] arr) {
        int x = 0;
        int ans = 0;
        for (int num : nums) {
            if (arr[x++] != num) ans++;
            if (x == arr.length) x = 0;
        }
        return ans;
    }

}