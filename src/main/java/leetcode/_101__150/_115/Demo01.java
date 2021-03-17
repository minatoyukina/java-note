package leetcode._101__150._115;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));

    }

    private int count;

    private int numDistinct(String s, String t) {
        count = 0;
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = map.getOrDefault(chars[i], new ArrayList<>());
            list.add(i);
            map.put(chars[i], list);
        }
        dfs(map, t, t.length() - 1, s.length());
        return count;
    }

    private void dfs(Map<Character, List<Integer>> map, String s, int index, int offset) {
        if (index < 0) {
            count++;
            return;
        }
        List<Integer> list = map.get(s.charAt(index));
        if (list == null) return;
        for (int i : list) {
            if (i < offset)
                dfs(map, s, index - 1, i);
        }
    }
}
