package leetcode._1__50._44;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isMatch("abcabczzzde", "*abc???de*"));
        System.out.println(isMatch("", "***********"));
    }

    private boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    private Boolean[][] dp;

    private boolean isMatch(String s, String p, int si, int pi) {
        if (dp[si][pi] != null) return dp[si][pi];
        if (si >= s.length() && p.substring(pi).replace("*", "").isEmpty()) return dp[si][pi] = true;
        if (si >= s.length() || pi >= p.length()) return si >= s.length() && pi >= p.length();
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') return dp[si][pi] = isMatch(s, p, si + 1, pi + 1);
        if (p.charAt(pi) == '*') {
            for (int i = si; i <= s.length(); i++) {
                if (isMatch(s, p, i, pi + 1)) {
                    return dp[si][pi] = true;
                }
            }
        }
        return dp[si][pi] = false;
    }

}