package leetcode._1101__1150._1143;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "def"));
        System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();
        int[][] dp = new int[x + 1][y + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int k = chars1[i] == chars2[j] ? 1 : 0;
                dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), dp[i][j] + k);
            }
        }
        return dp[x][y];
    }
}
