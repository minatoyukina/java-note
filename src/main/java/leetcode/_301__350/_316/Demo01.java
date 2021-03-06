package leetcode._301__350._316;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

@SuppressWarnings("all")
public class Demo01 {

    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("leetcode"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    private String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> map = new ConcurrentSkipListMap<>();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = map.get(chars[i]);
            if (list == null) list = new ArrayList<>();
            list.add(i);
            map.put(chars[i], list);
        }
        StringBuilder sb = new StringBuilder();
        int[] t = new int[1];
        label:
        while (!map.isEmpty()) {
            for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                Character x = entry.getKey();
                List<Integer> y = entry.getValue();
                for (Integer first : y) {
                    if (map.values().stream()
                            .allMatch(list -> first <= list.get(list.size() - 1) && first >= t[0])) {
                        sb.append(x);
                        map.remove(x);
                        t[0] = first;
                        continue label;
                    }
                }
            }
        }
        return sb.toString();
    }
}
