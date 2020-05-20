package leetcode._201__250._205;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void count() {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("egg", "add"));
    }

    private boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> m1 = new LinkedHashMap<>();
        Map<Character, List<Integer>> m2 = new LinkedHashMap<>();
        count(m1, s);
        count(m2, t);
        return Arrays.deepEquals(m1.values().toArray(), m2.values().toArray());

    }

    private void count(Map<Character, List<Integer>> m1, String s) {
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = m1.get(s.charAt(i));
            if (list == null) list = new ArrayList<>();
            list.add(i);
            m1.put(s.charAt(i), list);
        }
    }
}
