package leetcode._2351__2400._2384;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("00009"));
        System.out.println(largestPalindromic("444947137"));
    }

    public String largestPalindromic(String num) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num.length(); i++) {
            int k = num.charAt(i) - '0';
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        String s = map.entrySet().stream().map(y -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < y.getValue() / 2; i++) sb.append(y.getKey());
            return sb.toString();
        }).map(String::valueOf).collect(Collectors.joining());
        String ss = map.entrySet().stream().filter(x -> x.getValue() % 2 == 1).map(Map.Entry::getKey).map(String::valueOf).max(String::compareTo).orElse("");
        if (s.replace("0", "").isEmpty()) return ss.isEmpty() ? "0" : ss;
        return new StringBuilder(s).reverse().toString() + ss + s;
    }

}