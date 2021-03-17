package leetcode._351__400._395;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestSubstring("bbaaacbd", 3));
        System.out.println(longestSubstring("aaabb", 3));
    }

    private int res;

    private int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = map.getOrDefault(chars[i], new ArrayList<>());
            list.add(i);
            map.put(chars[i], list);
        }
        if (map.values().stream().allMatch(x -> x.size() >= k)) {
            res = Math.max(res, s.length());
        } else {
            for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size() < k) {
                    res = Math.max(res, longestSubstring(s.substring(0, list.get(0)), k));
                    res = Math.max(res, longestSubstring(s.substring(list.get(list.size() - 1) + 1), k));
                    for (int i = 0; i < list.size() - 1; i++) {
                        res = Math.max(res, longestSubstring(s.substring(list.get(i) + 1, list.get(i + 1)), k));
                    }
                    break;
                }
            }
        }
        return res;
    }

}