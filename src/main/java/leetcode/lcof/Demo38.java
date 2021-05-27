package leetcode.lcof;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo38 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("abc")));
        System.out.println(Arrays.toString(permutation("abcc")));
    }

    private String[] permutation(String s) {
        return dfs(s).toArray(new String[0]);
    }

    private Set<String> dfs(String s) {
        Set<String> ans = new HashSet<>();
        if (s.length() == 1) {
            ans.add(s);
            return ans;
        }
        String s1 = s.substring(1);
        Set<String> set = dfs(s1);
        for (String str : set) {
            for (int i = 0; i <= str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                sb.insert(i, s.charAt(0));
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
