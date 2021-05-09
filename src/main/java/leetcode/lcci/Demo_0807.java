package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0807 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("qwe")));
    }

    private String[] permutation(String S) {
        if (S.length() == 1) return new String[]{S};
        String[] permutation = permutation(S.substring(1));
        String[] ans = new String[(permutation[0].length() + 1) * permutation.length];
        int x = 0;
        for (String s : permutation) {
            char c = S.charAt(0);
            for (int i = 0; i <= s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                ans[x++] = sb.toString();
            }
        }
        return ans;
    }
}
