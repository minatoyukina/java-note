package leetcode._551__600._583;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(minDistance("leetcode", "etco"));
        System.out.println(minDistance("park", "spake"));
    }


    private int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                max = Math.max(max, dp[i][j]);
            }
        }
        return m + n - 2 * max;
    }

}