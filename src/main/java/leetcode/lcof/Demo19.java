package leetcode.lcof;

import org.junit.Test;

public class Demo19 {

    @Test
    public void test() {
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

    private boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int si, int pi) {
        return false;
    }
}
