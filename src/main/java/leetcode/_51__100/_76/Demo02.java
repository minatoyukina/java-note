package leetcode._51__100._76;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo02 {

    @Test
    public void test() {
        System.out.println(minWindow("bdab", "ab"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    private String minWindow(String s, String t) {
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE, offL = 0, offR = -1;
        while (right < s.length()) {
            cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            if (check(cnt, ori)) {
                while (cnt.get(s.charAt(left)) > ori.getOrDefault(s.charAt(left), 0) && left <= right) {
                    cnt.put(s.charAt(left), cnt.get(s.charAt(left)) - 1);
                    left++;
                }
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    offL = left;
                    offR = right;
                }
            }
            right++;
        }
        return s.substring(offL, offR + 1);
    }

    private boolean check(Map<Character, Integer> cnt, Map<Character, Integer> ori) {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            if (!cnt.containsKey(entry.getKey()) || cnt.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }
}
