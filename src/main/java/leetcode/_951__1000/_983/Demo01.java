package leetcode._951__1000._983;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }


    private int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length][8][31];
        return dfs(days, costs, 0, 0, 0);
    }

    private int[][][] dp;

    private int dfs(int[] days, int[] cost, int index, int r7, int r30) {
        if (index >= days.length) return 0;
        if (index > 0) {
            int pre = days[index - 1];
            r7 -= days[index] - pre;
            r30 -= days[index] - pre;
        }
        if (r7 < 0) r7 = 0;
        if (r30 < 0) r30 = 0;
        if (dp[index][r7][r30] != 0) return dp[index][r7][r30];
        int ans;
        int i = index + 1;
        if (r7 <= 0 && r30 <= 0) {
            int c1 = cost[0] + dfs(days, cost, i, r7, r30);
            int c2 = cost[1] + dfs(days, cost, i, 7, r30);
            int c3 = cost[2] + dfs(days, cost, i, r7, 30);
            ans = Math.min(c1, Math.min(c2, c3));
        } else {
            if (r7 <= 0) ans = Math.min(cost[1] + dfs(days, cost, i, 7, r30), dfs(days, cost, i, r7, r30));
            else if (r30 <= 0) ans = Math.min(dfs(days, cost, i, r7, r30), cost[2] + dfs(days, cost, i, r7, 30));
            else ans = dfs(days, cost, i, r7, r30);
        }
        return dp[index][r7][r30] = ans;
    }
}