package leetcode._1001__1050._1035;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
    }

    private int maxUncrossedLines(int[] nums1, int[] nums2) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i][j] = -1;
                if (nums1[i] == nums2[j]) {
                    Set<Integer> set = map.getOrDefault(i, new HashSet<>());
                    set.add(j);
                    map.put(i, set);
                }
            }
        }
        return dfs(map, nums1, 0, -1);
    }

    private int[][] dp;

    private int dfs(Map<Integer, Set<Integer>> map, int[] arr, int index, int max) {
        if (index >= arr.length) return 0;
        if (max >= 0 && dp[index][max] != -1) return dp[index][max];
        Set<Integer> set = map.getOrDefault(index, new HashSet<>());
        int ans = 0;
        for (int i : set) {
            if (i <= max) continue;
            ans = Math.max(ans, 1 + dfs(map, arr, index + 1, i));
        }
        int res = Math.max(ans, dfs(map, arr, index + 1, max));
        if (max >= 0) dp[index][max] = res;
        return res;
    }

}