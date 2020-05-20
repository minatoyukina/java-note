package leetcode._438;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int length = p.length();
        if (s.length() < length) return list;
        Map<String, Long> map = Arrays.stream(p.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> tmp = Arrays.stream(s.substring(0, length).split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < s.length() - length; i++) {
            if (tmp.equals(map)) list.add(i);
            String key = s.charAt(i) + "";
            Long value = tmp.get(key);
            if (value != null) {
                if (value > 1) tmp.put(key, value - 1);
                else tmp.remove(key);
            }
            String key2 = s.charAt(i + length) + "";
            if (tmp.get(key2) != null) tmp.put(key2, tmp.get(key2) + 1);
            else tmp.put(key2, 1L);
            if (i == s.length() - length - 1 && tmp.equals(map)) list.add(i + 1);
        }
        return list;
    }
}
