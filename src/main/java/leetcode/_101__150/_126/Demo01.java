package leetcode._101__150._126;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findLadders("hot", "aaa", new ArrayList<>(Arrays.asList("hot", "dog", "dot"))));
        System.out.println(findLadders("a", "c", new ArrayList<>(Arrays.asList("a", "b", "c"))));

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<Pair<String, String>>> list = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> sub = new HashSet<>();
            boolean flag = false;
            while (size-- > 0) {
                String poll = queue.poll();
                assert poll != null;
                for (String word : wordList) {
                    if (!visited.contains(word) && check(poll, word)) {
                        queue.offer(word);
                        if (list.size() <= step) list.add(new ArrayList<>());
                        List<Pair<String, String>> pairs = list.get(step);
                        Pair<String, String> pair = new Pair<>(poll, word);
                        if (!pairs.contains(pair)) pairs.add(pair);
                        sub.add(word);
                        if (word.equals(endWord)) flag = true;
                    }
                }
            }
            if (flag) break;
            visited.addAll(sub);
            step++;
        }
        List<List<String>> ans = new ArrayList<>();
        if (list.size() == 0 || list.get(list.size() - 1).stream().noneMatch(s -> s.getValue().equals(endWord)))
            return ans;
        dfs(list, ans, new ArrayList<>(), list.size() - 1, endWord);
        return ans;
    }

    private boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (count > 1) break;
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
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
                dfs(list, ans, new ArrayList<>(cur), level - 1, pair.getKey());
            }
        }
    }

}