package leetcode._2001__2050._2007;

import org.junit.Test;

import java.util.*;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1, 6, 3, 2, 8, 4})));
    }

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[0];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : changed) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue(), half = k / 2;
            if (k == 0) {
                if (v % 2 == 1) return new int[0];
                else for (int i = v / 2; i > 0; i--) list.add(0);
            } else {
                if (k % 2 == 1 || !map.containsKey(half)) for (int i = 0; i < v; i++) list.add(k);
                else if (k % 2 == 0 && map.containsKey(half)) {
                    if (v < map.get(half)) return new int[0];
                    for (int i = 0; i < v - map.get(half); i++) list.add(k);
                    map.put(k, v - map.get(half));
                }
            }
        }
        if (list.size() != n / 2) return new int[0];
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
