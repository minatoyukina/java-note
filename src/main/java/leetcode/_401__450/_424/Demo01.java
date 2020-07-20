package leetcode._401__450._424;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(characterReplacement("ABAABA", 2));
        System.out.println(characterReplacement("ABAABACA", 3));
    }

    private int characterReplacement(String s, int k) {
        Map<Character, Pair<Integer, Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                Pair<Integer, Integer> pair = map.get(c);
                if (pair.getKey() > 0)
                    map.put(c, new Pair<>(pair.getKey() - 1, pair.getValue() + 1));
            } else {
                map.put(c, new Pair<>(k, 1));
            }
        }
        return map.values().stream().mapToInt(Pair::getValue).max().orElse(0);
    }

}
