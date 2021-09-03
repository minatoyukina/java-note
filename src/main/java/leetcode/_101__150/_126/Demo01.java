package leetcode._101__150._126;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findLadders("hit", "cog",
                new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<Pair<String, String>>> list = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                assert poll != null;
                if (poll.equals(endWord)) {
                    continue;
                }
                for (String word : wordList) {
                    int t = 0;
                    for (int j = 0; j < poll.length(); j++) if (poll.charAt(j) == word.charAt(j)) t++;
                    if (t == poll.length() - 1 && !visited.contains(word)) {
                        queue.offer(word);
                        if (list.size() <= step) list.add(new ArrayList<>());
                        list.get(step).add(new Pair<>(poll, word));
                        visited.add(word);
                    }
                }
            }
            step++;
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(list, ans, new ArrayList<>(), list.size() - 1, endWord);
        return ans;
    }

    private void dfs(List<List<Pair<String, String>>> list, List<List<String>> ans, List<String> cur, int level, String s) {
        cur.add(s);
        if (level < 0) {
            Collections.reverse(cur);
            ans.add(cur);
            return;
        }
        List<Pair<String, String>> pairs = list.get(level);
        for (Pair<String, String> pair : pairs) {
            if (Objects.equals(pair.getValue(), s)) {
                dfs(list, ans, cur, level - 1, pair.getKey());
            }
        }
    }

}