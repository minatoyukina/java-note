package leetcode._1151__1200._1156;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxRepOpt1("ababa"));
        System.out.println(maxRepOpt1("aaabbaaa"));
        System.out.println(maxRepOpt1("aaabaaa"));
        System.out.println(maxRepOpt1("abcde"));
    }

    public int maxRepOpt1(String text) {
        Map<Character, List<Pair<Integer, Integer>>> map = new HashMap<>();
        int pos = 0;
        for (int i = 0; i <= text.length(); i++) {
            char c = text.charAt(pos);
            if (i == text.length() || c != text.charAt(i)) {
                List<Pair<Integer, Integer>> list = map.computeIfAbsent(c, k -> new ArrayList<>());
                list.add(new Pair<>(pos, i));
                pos = i;
            }
        }
        int max = 0;
        for (List<Pair<Integer, Integer>> value : map.values()) {
            for (Pair<Integer, Integer> pair : value)
                max = Math.max(max, pair.getValue() - pair.getKey() + (value.size() > 1 ? 1 : 0));
            for (int i = 0; i < value.size() - 1; i++) {
                Pair<Integer, Integer> p2 = value.get(i + 1);
                Pair<Integer, Integer> p1 = value.get(i);
                if (p2.getKey() == p1.getValue() + 1)
                    max = Math.max(max, p1.getValue() + p2.getValue() - p1.getKey() - p2.getKey() + (value.size() > 2 ? 1 : 0));
            }
        }
        return max;
    }

}