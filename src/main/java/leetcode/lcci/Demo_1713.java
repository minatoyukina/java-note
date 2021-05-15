package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1713 {

    @Test
    public void test() {
        System.out.println(respace(new String[]{"looked", "just", "like", "her", "brother"},
                "jesslookedjustliketimherbrother"));
        System.out.println(respace(new String[]{"looked", "just", "like", "her", "brother"},
                "esslookedjustliketimherbrother"));
    }

    private int respace(String[] dictionary, String sentence) {
        dp = new int[sentence.length() + 1];
        Arrays.fill(dp, -1);
        int min = Integer.MAX_VALUE, max = 0;
        Set<String> set = new HashSet<>();
        for (String s : dictionary) {
            min = Math.min(min, s.length());
            max = Math.max(max, s.length());
            set.add(s);
        }
        return dfs(set, sentence, 0, min, max);
    }

    private int[] dp;

    private int dfs(Set<String> dic, String s, int index, int min, int max) {
        if (dp[index] >= 0) return dp[index];
        if (index >= s.length()) return dp[index] = 0;
        int l = s.length() - index;
        if (l < min) return dp[index] = l;
        int ans = s.length();
        for (int i = index + min; i <= Math.min(s.length(), index + max); i++) {
            if (dic.contains(s.substring(index, i))) {
                ans = Math.min(ans, dfs(dic, s, i, min, max));
            }
        }
        return dp[index] = Math.min(ans, 1 + dfs(dic, s, index + 1, min, max));
    }
}
