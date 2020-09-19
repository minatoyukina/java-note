package leetcode._101__150._139;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(wordBreak("dogs", Arrays.asList("dog", "s", "gs")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    private boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String sub = s.substring(0, i + 1);
            if (set.contains(sub)) dp[i] = true;
            else {
                for (String word : wordDict) {
                    if (sub.endsWith(word)) {
                        dp[i] = dp[i] || dp[i - word.length()];
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

}
