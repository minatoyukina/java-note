package leetcode._501__550._516;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
        System.out.println(longestPalindromeSubseq("cc"));

    }

    private int longestPalindromeSubseq(String s) {
        StringBuilder s1 = new StringBuilder(s).reverse();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i + j >= s.length()) continue;
                char a = s.charAt(i);
                char b = s1.charAt(j);
                int max = Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i + 1][j + 1] = Math.max(max, dp[i][j] + (a == b ? (i + j == s.length() - 1 ? 1 : 2) : 0));
            }
        }
        int ans = 0;
        for (int[] ints : dp) {
            for (int i : ints) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

}
