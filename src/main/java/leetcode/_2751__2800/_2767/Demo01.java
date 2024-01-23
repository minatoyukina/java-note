package leetcode._2751__2800._2767;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumBeautifulSubstrings("101101111101"));
    }

    public int minimumBeautifulSubstrings(String s) {
        int dfs = dfs(s);
        return dfs >= 1000 ? -1 : dfs;
    }

    Map<String, Integer> map = new HashMap<>();

    private int dfs(String s) {
        if (check(s)) return 1;
        if (map.containsKey(s)) return map.get(s);
        int min = 1000;
        for (int i = 1; i < s.length(); i++) min = Math.min(dfs(s.substring(0, i)) + dfs(s.substring(i)), min);
        map.put(s, min);
        return min;
    }

    private boolean check(String s) {
        if (s.startsWith("0")) return false;
        int x = Integer.valueOf(s, 2);
        int y = (int) (Math.log(x) / Math.log(5));
        return Math.pow(5, y) == x;
    }

}