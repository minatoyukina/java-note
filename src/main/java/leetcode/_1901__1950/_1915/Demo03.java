package leetcode._1901__1950._1915;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo03 {


    @Test
    public void test() {
        System.out.println(wonderfulSubstrings("fiabhedce"));
        System.out.println(wonderfulSubstrings("aabb"));
    }

    private long wonderfulSubstrings(String word) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cur = 0;
        for (int i = 0; i < word.length(); i++) {
            cur ^= 1 << word.charAt(i) - 'a';
            sum += map.getOrDefault(cur, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            for (int j = 0; j < 10; j++) sum += map.getOrDefault(cur ^ (1 << j), 0);
        }
        return sum;
    }
}