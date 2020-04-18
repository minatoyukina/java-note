package leetcode._101__150._139;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    private boolean wordBreak(String s, List<String> wordDict) {
        AtomicReference<Boolean> flag = new AtomicReference<>(false);
        wordBreak(s, wordDict, flag);
        return flag.get();
    }

    private void wordBreak(String s, List<String> wordDict, AtomicReference<Boolean> flag) {
        flag.set(flag.get() || s.length() == 0);
        for (String s1 : wordDict) {
            if (s.indexOf(s1) == 0) {
                wordBreak(s.substring(s1.length()), wordDict, flag);
            }
        }
    }
}
