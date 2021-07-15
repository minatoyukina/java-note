package leetcode._101__150._132;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minCut("ccaacabacb"));
        System.out.println(minCut("leetcode"));
        System.out.println(minCut("abc"));
    }

    private int minCut(String s) {
        dp = new int[s.length()][s.length()];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(s, 0, s.length() - 1);
    }

    private int[][] dp;

    private int dfs(String s, int left, int right) {
        if (left >= right) return 0;
        if (dp[left][right] != -1) return dp[left][right];
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int[] p1 = partition(s, i, i, left, right);
            min = Math.min(min, dfs(s, left, p1[0] - 1) + dfs(s, p1[1] + 1, right) +
                    (p1[0] <= left ? 0 : 1) + (p1[1] >= right ? 0 : 1));
            if (i + 1 <= right && s.charAt(i) == s.charAt(i + 1)) {
                int[] p2 = partition(s, i, i + 1, left, right);
                min = Math.min(min, dfs(s, left, p2[0] - 1) + dfs(s, p2[1] + 1, right) +
                        (p2[0] <= left ? 0 : 1) + (p2[1] >= right ? 0 : 1));
            }

        }
        return dp[left][right] = min;
    }

    private int[] partition(String s, int l, int r, int left, int right) {
        while (l >= left && r <= right) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else break;
        }
        return new int[]{l + 1, r - 1};
    }
}