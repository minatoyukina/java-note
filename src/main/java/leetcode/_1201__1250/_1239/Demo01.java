package leetcode._1201__1250._1239;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxLength(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")));

    }

    private int maxLength(List<String> arr) {
        arr = arr.stream().filter(s -> new HashSet<>(Arrays.stream(s.split(""))
                .collect(Collectors.toList())).size() == s.length())
                .collect(Collectors.toList());
        return dfs(arr, 0, "");
    }


    private int dfs(List<String> arr, int pos, String pre) {
        int max = 0;
        label:
        for (int i = pos; i < arr.size(); i++) {
            int reduce = arr.subList(i, arr.size()).stream().map(String::length).reduce(0, Integer::sum);
            if (max >= reduce) return max;
            String s = arr.get(i);
            for (char c : s.toCharArray()) {
                if (pre.contains(String.valueOf(c))) continue label;
            }
            max = Math.max(max, s.length() + dfs(arr, pos + 1, pre + s));
        }
        return max;
    }

}