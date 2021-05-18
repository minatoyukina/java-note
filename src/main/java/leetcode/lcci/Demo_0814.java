package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0814 {

    @Test
    public void test() {
        System.out.println(countEval("1^0|0|1", 0));
        System.out.println(countEval("0&0&0&1^1|0", 1));
    }

    private int countEval(String s, int result) {
        return dfs(new StringBuilder(s), result);
    }

    private int dfs(StringBuilder s, int result) {
        if (s.indexOf("|") < 0 && s.indexOf("&") < 0 && s.indexOf("^") < 0) {
            return Integer.parseInt(s.toString()) == result ? 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = i;
            while (x < s.length() && s.charAt(x) >= '0' && s.charAt(x) <= '9') x++;
            int z = x;
            int y = z + 1;
            while (y < s.length() && s.charAt(y) >= '0' && s.charAt(y) <= '9') y++;
            if (y <= s.length() && x > i && (s.charAt(z) <= '0' || s.charAt(z) >= '9') && y > z + 1) {
                StringBuilder sb = new StringBuilder(s);
                int c = compute(Integer.parseInt(sb.substring(i, x)), Integer.parseInt(sb.substring(z + 1, y)), sb.charAt(z));
                sb.replace(i, y, c + "");
                ans += dfs(sb, result);
            }
        }
        return ans;
    }

    private int compute(int x, int y, char c) {
        if (c == '|') return x | y;
        if (c == '&') return x & y;
        else return x ^ y;
    }
}
