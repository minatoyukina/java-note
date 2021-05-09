package leetcode._1451__1500._1482;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }


    private int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;
        int[] arr = new int[n + 1 - k];
        int x = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            int max = 0;
            if (i + k > bloomDay.length) break;
            for (int j = i; j < i + k; j++) max = Math.max(max, bloomDay[j]);
            arr[x++] = max;
        }
        dp = new HashMap<>();
        return dfs(arr, m, k, 0, 0);
    }

    private Map<Integer, Map<Integer, Integer>> dp;

    private int dfs(int[] arr, int m, int k, int index, int count) {
        if (count >= m) return 0;
        int ans = Integer.MAX_VALUE;
        if (index >= arr.length) return ans;
        if (dp.getOrDefault(index, new HashMap<>()).containsKey(count)) return dp.get(index).get(count);
        for (int i = index; i < arr.length; i++) {
            if ((m - count - 1) * k + 1 > arr.length - i) break;
            int dfs = dfs(arr, m, k, i + k, count + 1);
            ans = Math.min(ans, Math.max(arr[i], dfs));
        }
        Map<Integer, Integer> sub = dp.getOrDefault(index, new HashMap<>());
        sub.put(count, ans);
        dp.put(index, sub);
        return ans;
    }
}
