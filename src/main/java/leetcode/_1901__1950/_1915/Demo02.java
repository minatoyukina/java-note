package leetcode._1901__1950._1915;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(wonderfulSubstrings("fiabhedce"));
        System.out.println(wonderfulSubstrings("aabb"));
    }

    private long wonderfulSubstrings(String word) {
        long sum = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0000000000", 1);
        String[] pre = new String[word.length() + 1];
        pre[0] = "0000000000";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int x = c - 'a';
            pre[i + 1] = new StringBuilder(pre[i]).replace(x, x + 1, pre[i].charAt(x) == '1' ? "0" : "1").toString();
            String key = pre[i + 1];
            sum += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
            for (int j = 0; j < 10; j++) {
                StringBuilder sb = new StringBuilder(key).replace(j, j + 1, key.charAt(j) == '1' ? "0" : "1");
                sum += map.getOrDefault(sb.toString(), 0);
            }
        }
        return sum;
    }
}