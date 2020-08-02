package leetcode._451__500._474;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10", "1", "0"}, 1, 1));
        System.out.println(findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3));
    }

    private int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        Set<String> set = new HashSet<>();
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        for (String str : strs) {
            Map<String, Long> map = Arrays.stream(str.split(""))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            Long z = map.getOrDefault("0", 0L);
            Long o = map.getOrDefault("1", 0L);
            if (set.contains(str)) count++;
            else if (z <= m && o <= n) {
                set.add(str);
                count++;
                m -= z;
                n -= o;
            }
        }
        return count;
    }

}
