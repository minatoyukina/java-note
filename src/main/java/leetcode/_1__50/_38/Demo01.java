package leetcode._1__50._38;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(30));
    }

    private String countAndSay(int n) {
        return convert(n, "1");
    }

    private String convert(int n, String s) {
        if (n == 1) {
            return s;
        }
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>(2);
            char c = s.charAt(i);
            if (list.isEmpty() || !list.get(list.size() - 1).containsKey(c)) {
                map.put(c, 1);
                list.add(map);
            } else {
                Map<Character, Integer> tmp = list.get(list.size() - 1);
                if (tmp.containsKey(c)) {
                    tmp.put(c, tmp.get(c) + 1);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        list.forEach(l -> l.forEach((x, y) -> str.append(y).append(x)));
        return convert(--n, str.toString());
    }
}
