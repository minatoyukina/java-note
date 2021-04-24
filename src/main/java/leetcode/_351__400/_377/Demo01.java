package leetcode._351__400._377;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(combinationSum4(new int[]{2, 1, 3}, 35));
    }

    private int[] dp;

    private int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (dp[target] >= 0) return dp[target];
        int ans = 0;
        for (int num : nums) ans += dfs(nums, target - num);
        dp[target] = ans;
        return ans;
    }
}
