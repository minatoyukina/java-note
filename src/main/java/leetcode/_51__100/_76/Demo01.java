package leetcode._51__100._76;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    private String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                list.add(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (count.get(k) == null || count.get(k) < v) return "";
        }
        dp = new HashMap<>();
        return dfs(s, count, map, 0, list.size() - 1, list);
    }

    private Map<Integer, Map<Integer, String>> dp;

    private String dfs(String s, Map<Character, Integer> count, Map<Character, Integer> map, int leftIndex, int rightIndex, List<Integer> list) {
        if (leftIndex >= list.size() || rightIndex < 0) return "";
        if (dp.getOrDefault(leftIndex, new HashMap<>()).containsKey(rightIndex))
            return dp.get(leftIndex).get(rightIndex);
        int left = list.get(leftIndex), right = list.get(rightIndex);
        char l = s.charAt(left), r = s.charAt(right);
        String s1 = "", s2 = "";
        if (count.get(l) > map.get(l)) {
            count.put(l, count.get(l) - 1);
            s1 = dfs(s, count, map, leftIndex + 1, rightIndex, list);
            count.put(l, count.get(l) + 1);
        }
        if (count.get(r) > map.get(r)) {
            count.put(r, count.get(r) - 1);
            s2 = dfs(s, count, map, leftIndex, rightIndex - 1, list);
            count.put(r, count.get(r) + 1);
        }
        String ans;
        if (s1.isEmpty() && s2.isEmpty()) ans = s.substring(left, right + 1);
        else if (s1.isEmpty() || s2.isEmpty()) ans = s1.isEmpty() ? s2 : s1;
        else ans = s1.length() > s2.length() ? s2 : s1;
        Map<Integer, String> sub = dp.getOrDefault(leftIndex, new HashMap<>());
        sub.put(rightIndex, ans);
        dp.put(leftIndex, sub);
        return ans;
    }
}
