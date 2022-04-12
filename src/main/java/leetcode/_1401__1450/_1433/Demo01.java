package leetcode._1401__1450._1433;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkIfCanBreak("leetcode", "interview"));
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        return check(s1, s2) || check(s2, s1);
    }

    public boolean check(String s1, String s2) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            Map.Entry<Character, Integer> entry = map.ceilingEntry(s2.charAt(i));
            if (entry == null) return false;
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (v == 1) map.remove(k);
            else map.put(k, v - 1);
        }
        return true;
    }

}