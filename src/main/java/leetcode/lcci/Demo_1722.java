package leetcode.lcci;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1722 {

    @Test
    public void test() {
        System.out.println(findLadders("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders("hot", "dog", Lists.newArrayList("hot", "dog", "dot")));
    }

    private List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) return ans;
        dfs(beginWord, endWord, wordList, ans, new HashSet<>());
        if (!ans.isEmpty()) ans.add(0, beginWord);
        return ans;

    }

    private boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (count > 1) return false;
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
    }

    private List<String> dfs(String beginWord, String endWord, List<String> dic, List<String> ans, Set<String> visited) {
        if (beginWord.equals(endWord)) return ans;
        visited.add(beginWord);
        for (String s : dic) {
            if (visited.contains(s) || !check(beginWord, s)) continue;
            ans.add(s);
            List<String> dfs = dfs(s, endWord, dic, ans, visited);
            if (!dfs.isEmpty()) return dfs;
            ans.remove(s);
        }
        return new ArrayList<>();
    }
}
