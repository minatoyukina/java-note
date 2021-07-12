package leetcode.lcof;

import org.junit.Test;

public class Demo19 {

    @Test
    public void test() {
        System.out.println(isMatch("baabbbaccbccacacc", "c*..b*a*a.*a..*c"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aaa", "ab*a"));
        System.out.println(isMatch("aa", "a"));
    }

    private boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return dfs(s, p, s.length() - 1, p.length() - 1);
    }

    private Boolean[][] dp;

    private boolean check(String p, int pi) {
        for (int i = 0; i <= pi; i++) if (i % 2 == 1 && p.charAt(i) != '*') return false;
        return true;
    }

    private boolean dfs(String s, String p, int si, int pi) {
        if (si < 0 && pi < 0) return true;
        // 如果s匹配完p还剩下.*x*之类直接返回true
        if (si < 0 && pi % 2 == 1) if (check(p, pi)) return true;
        if (si < 0 || pi < 0) return false;
        if (dp[si][pi] != null) return dp[si][pi];
        char sc = s.charAt(si), pc = p.charAt(pi);
        boolean ans = false;
        if (pc == '*') {
            char pre = p.charAt(pi - 1);
            // .*匹配0~所有
            if (pre == '.') {
                for (int i = -1; i <= si; i++) {
                    if (dfs(s, p, i, pi - 2)) {
                        ans = true;
                        break;
                    }
                }
                // x*
            } else {
                int x = si;
                // x*匹配0个
                if (dfs(s, p, x, pi - 2)) ans = true;
                    // x*匹配s重复字符
                else if (pre == sc) {
                    while (x >= 0 && s.charAt(x) == sc) {
                        if (dfs(s, p, x - 1, pi - 2)) {
                            ans = true;
                            break;
                        }
                        x--;
                    }
                }
            }
        } else if (pc == '.' || pc == sc) ans = dfs(s, p, si - 1, pi - 1);
        return dp[si][pi] = ans;
    }
}
