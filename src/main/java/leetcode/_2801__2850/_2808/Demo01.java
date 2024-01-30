package leetcode._2801__2850._2808;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumSeconds(Arrays.asList(5, 5, 5, 5)));
        System.out.println(minimumSeconds(Arrays.asList(2, 1, 3, 3, 2)));
    }

    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.size(), min = n;
        for (int i = 0; i < n; i++) map.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        for (List<Integer> value : map.values()) {
            int max = 0, s = value.size();
            for (int i = 0; i < s; i++) {
                max = Math.max(max, (i == s - 1 ? (n - value.get(i) + value.get(0)) : (value.get(i + 1) - value.get(i))) / 2);
            }
            min = Math.min(min, max);
        }
        return min;
    }

}