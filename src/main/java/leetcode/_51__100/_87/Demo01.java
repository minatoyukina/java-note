package leetcode._51__100._87;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isScramble("abcdbdacbdac", "bdacabcdbdac"));
        System.out.println(isScramble("great", "rgeat"));
    }

    private Map<String, Boolean> map = new HashMap<>();

    private boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2)) return true;
        String key = s1 + s2;
        if (map.containsKey(key)) return map.get(key);
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(key, true);
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

}
