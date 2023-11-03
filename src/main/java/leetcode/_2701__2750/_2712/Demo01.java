package leetcode._2701__2750._2712;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumCost("00000000"));
        System.out.println(minimumCost("010101"));
    }

    public long minimumCost(String s) {
        if (s.replace("0", "").isEmpty() || s.replace("1", "").isEmpty()) return 0;
        return dfs(0, s.length() - 1, s.charAt(0) == '1', s.charAt(s.length() - 1) == '1', s);
    }

    private long dfs(int l, int r, boolean lc, boolean rc, String s) {
        if (l >= r - 1) return lc == rc ? 0 : Math.min(l + 1, s.length() - r);
        int dl = 0, dr = 0, nl = l, nr = r;
        for (int i = l; i < s.length(); i++) {
            if (s.charAt(i) == '1' != lc) {
                dl = i;
                nl = i;
                break;
            } else l = i;
        }
        for (int i = r; i >= 0; i--) {
            if (s.charAt(i) == '1' != rc) {
                dr = s.length() - i - 1;
                nr = i;
                break;
            } else r = i;
        }
        if (dl <= dr) return dl + dfs(nl, r, !lc, rc, s);
        else return dr + dfs(l, nr, lc, !rc, s);
    }

}