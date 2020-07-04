package leetcode._101__150._127;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(ladderLength("hit", "cog",
                new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(ladderLength("hot", "dog",
                new ArrayList<>(Arrays.asList("hot", "dog"))));
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            List<String> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                String first = queue.pollFirst();
                assert first != null;
                if (first.equals(endWord)) return count;
                for (String word : wordList) {
                    int t = 0;
                    for (int j = 0; j < first.length(); j++)
                        if (first.charAt(j) == word.charAt(j)) t++;
                    if (t == first.length() - 1 && !visited.contains(word)) {
                        next.add(word);
                        visited.add(word);
                    }
                }
            }
            count++;
            queue.addAll(next);

        }
        return 0;
    }

}
