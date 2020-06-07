package leetcode._791;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("cbad", "abcdea"));
    }

    private String customSortString(String S, String T) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : S.toCharArray()) map.put(c, 0);
        for (char c : T.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((x, y) -> {
            for (int i = 0; i < y; i++) sb.append(x);
        });
        return sb.toString();
    }
}
