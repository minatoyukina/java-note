package leetcode._1401__1450._1449;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));
        System.out.println(largestNumber(new int[]{1, 1, 1, 1, 1, 1, 1, 3, 2}, 10));
        System.out.println(largestNumber(new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40}, 47));
    }

    private String largestNumber(int[] cost, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) map.put(cost[i], i);
        int[] index = map.values().stream().mapToInt(Integer::intValue).toArray();
        dp = new String[target + 1];
        return dfs(index, cost, target);
    }

    private String[] dp;

    private String dfs(int[] index, int[] cost, int target) {
        if (target == 0) return "";
        if (dp[target] != null) return dp[target];
        String ans = "0";
        for (int i : index) {
            if (target - cost[i] < 0) continue;
            String dfs = dfs(index, cost, target - cost[i]);
            if (dfs.endsWith("0")) continue;
            dfs = i + 1 + dfs;
            if (dfs.length() > ans.length() || (dfs.length() == ans.length() && dfs.compareTo(ans) > 0)) ans = dfs;
        }
        return dp[target] = ans;
    }
}