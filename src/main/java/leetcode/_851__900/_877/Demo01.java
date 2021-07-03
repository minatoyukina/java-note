package leetcode._851__900._877;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(stoneGame(new int[]{5, 3}));
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
        System.out.println(stoneGame(new int[]{4, 3, 4, 3, 2, 5}));
    }

    private boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles) sum += pile;
        dp = new int[piles.length][piles.length];
        return dfs(piles, 0, piles.length - 1) * 2 > sum;
    }

    private int[][] dp;

    private int dfs(int[] piles, int left, int right) {
        if (dp[left][right] > 0) return dp[left][right];
        if (left >= right) return 0;
        boolean myTurn = (right + 1 - left) % 2 == 0;
        int a = (myTurn ? piles[left] : 0) + dfs(piles, left + 1, right);
        int b = (myTurn ? piles[right] : 0) + dfs(piles, left, right - 1);
        return dp[left][right] = Math.max(a, b);
    }

}
