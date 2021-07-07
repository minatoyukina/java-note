package leetcode._551__600._583;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("abc", "ac"));
    }

    private Map<String, Map<String, Integer>> map = new HashMap<>();

    private int minDistance(String word1, String word2) {
        if (map.getOrDefault(word1, new HashMap<>()).containsKey(word2)) return map.get(word1).get(word2);
        if (word1.equals(word2)) return 0;
        if (word1.length() == 0 || word2.length() == 0) return Math.abs(word1.length() - word2.length());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < word1.length(); i++) {
            min = Math.min(min, 1 + minDistance(new StringBuilder(word1).deleteCharAt(i).toString(), word2));
        }
        for (int i = 0; i < word2.length(); i++) {
            min = Math.min(min, 1 + minDistance(word1, new StringBuilder(word2).deleteCharAt(i).toString()));
        }
        Map<String, Integer> sub = map.getOrDefault(word1, new HashMap<>());
        sub.put(word2, min);
        map.put(word1, sub);
        return min;
    }

}