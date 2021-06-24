package leetcode.lcci;

import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1715 {

    @Test
    public void test() {
        System.out.println(longestWord(new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"}));
    }

    private String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        for (int i = words.length - 1; i >= 0; i--) {
            set.remove(words[i]);
            if (dfs(words[i], 0, set)) return words[i];
            set.add(words[i]);
        }
        return "";
    }

    private boolean dfs(String word, int pos, Set<String> set) {
        if (pos >= word.length()) return true;
        for (int i = pos; i < word.length(); i++) {
            String s = word.substring(pos, i + 1);
            if (set.contains(s) && dfs(word, i + 1, set)) return true;
        }
        return false;
    }
}
