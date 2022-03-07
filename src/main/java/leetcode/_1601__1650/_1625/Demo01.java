package leetcode._1601__1650._1625;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findLexSmallestString("43987654", 7, 3));
        System.out.println(findLexSmallestString("5525", 9, 2));
    }

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set = new HashSet<>();
        dfs(s, a, b, set);
        return new TreeSet<>(set).first();
    }

    private void dfs(String s, int a, int b, Set<String> set) {
        if (set.contains(s)) return;
        set.add(s);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 1) {
                int x = c - '0' + a;
                sb.replace(i, i + 1, String.valueOf(x > 9 ? (x - 10) : x));
            }
        }
        dfs(sb.toString(), a, b, set);
        dfs(s.substring(s.length() - b) + s.substring(0, s.length() - b), a, b, set);
    }

}