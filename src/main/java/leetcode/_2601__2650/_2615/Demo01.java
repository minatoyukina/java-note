package leetcode._2601__2650._2615;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(distance(new int[]{1, 3, 1, 1, 2})));
        System.out.println(Arrays.toString(distance(new int[]{0, 5, 3})));
    }

    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Long>> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            List<Long> list = sum.getOrDefault(nums[i], new ArrayList<>());
            sum.put(nums[i], list);
            if (list.isEmpty()) list.add((long) i);
            else list.add(i + list.get(list.size() - 1));
        }
        long[] ans = new long[nums.length];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Long> list = sum.get(entry.getKey());
            if (list.size() == 1) continue;
            List<Integer> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                Integer x = value.get(i);
                ans[x] = list.get(list.size() - 1) - list.get(i) - (i == 0 ? 0 : list.get(i - 1)) + (long) x * (2 * i - list.size() + 1);
            }
        }
        return ans;
    }

}