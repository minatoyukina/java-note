package leetcode._51__100._97;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("", "", "a"));
    }

    private boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1][2];
        return dfs(s1, s2, s3, 0, 0, 1) || dfs(s1, s2, s3, 0, 0, 0);
    }

    private Boolean[][][] dp;

    private boolean dfs(String s1, String s2, String s3, int i1, int i2, int preIsA) {
        if (i1 == s1.length() && i2 == s2.length()) return true;
        if (dp[i1][i2][preIsA] != null) return dp[i1][i2][preIsA];
        if (preIsA == 1) {
            for (int i = i2; i < s2.length(); i++) {
                if (i1 + i >= s3.length() || s2.charAt(i) != s3.charAt(i1 + i)) break;
                if (dfs(s1, s2, s3, i1, i + 1, 0)) return dp[i1][i2][preIsA] = true;
            }
        } else {
            for (int i = i1; i < s1.length(); i++) {
                if (i2 + i >= s3.length() || s1.charAt(i) != s3.charAt(i2 + i)) break;
                if (dfs(s1, s2, s3, i + 1, i2, 1)) return dp[i1][i2][preIsA] = true;
            }
        }
        return dp[i1][i2][preIsA] = false;
    }

}
