package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0808 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("qwe")));
        System.out.println(Arrays.toString(permutation("qqe")));
    }

    private String[] permutation(String S) {
        return dfs(S).toArray(new String[0]);
    }

    private Set<String> dfs(String S) {
        if (S.length() == 1) return new HashSet<>(Collections.singletonList(S));
        Set<String> set = dfs(S.substring(1));
        Set<String> ans = new HashSet<>();
        for (String s : set) {
            for (int i = 0; i <= s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, S.charAt(0));
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
