package leetcode.lcci;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1722 {

    @Test
    public void test() {
        System.out.println(findLadders("hit", "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders("hot", "dot",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    private List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        List<String> ans = new ArrayList<>();
        dfs(beginWord, endWord, set, ans);
        return ans;

    }

    private void dfs(String beginWord, String endWord, Set<String> dic, List<String> list) {
        if (beginWord.equals(endWord)) return;
        for (String s : dic) {

        }
    }
}
