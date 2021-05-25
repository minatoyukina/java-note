package leetcode._1751__1800._1787;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo01 {


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
        List<int[]> dfs = dfs(map, 0, k);
        int ans = Integer.MAX_VALUE;
        for (int[] arr : dfs) {
            int tot = 0;
            for (int i : arr) tot ^= i;
            if (tot == 0) ans = Math.min(ans, check(nums, arr));
            else {
                for (int j = 0; j < arr.length; j++) {
                    int tmp = arr[j];
                    arr[j] = tot ^ arr[j];
                    ans = Math.min(ans, check(nums, arr));
                    arr[j] = tmp;
                }
            }
        }
        return ans;
    }

    private List<int[]> dfs(Map<Integer, Map<Integer, Integer>> map, int index, int k) {
        if (index >= k) return new ArrayList<>();
        List<int[]> dfs = dfs(map, index + 1, k);
        Map<Integer, Integer> sub = map.get(index);
        Integer max = sub.values().stream().max(Integer::compareTo).orElse(0);
        List<Integer> collect = sub.entrySet().stream().filter(s -> s.getValue().equals(max)).map(Map.Entry::getKey).collect(Collectors.toList());
        List<int[]> ans = new ArrayList<>();
        for (Integer i : collect) {
            if (dfs.isEmpty()) {
                int[] clone = new int[k];
                clone[index] = i;
                ans.add(clone);
            } else {
                for (int[] ints : dfs) {
                    int[] clone = ints.clone();
                    clone[index] = i;
                    ans.add(clone);
                }
            }
        }
        return ans;
    }

    @SuppressWarnings("all")
    private int check(int[] nums, int[] arr) {
        int x = 0;
        int ans = 0;
        for (int num : nums) {
            if (arr[x++] != num) ans++;
            if (x == arr.length) x = 0;
        }
        return ans;
    }

}