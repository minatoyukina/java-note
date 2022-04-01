package leetcode._951__1000._954;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canReorderDoubled(new int[]{1, 2, 4, 8}));
        System.out.println(canReorderDoubled(new int[]{3, 1, 3, 6}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        int zero = map.getOrDefault(0, 0);
        if (zero % 2 != 0) return false;
        map.remove(0);
        return dfs(map);
    }

    private boolean dfs(Map<Integer, Integer> map) {
        if (map.isEmpty()) return true;
        Set<Integer> lo = new HashSet<>(), hi = new HashSet<>(), mi = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            if (k % 2 == 1) lo.add(k);
            else {
                if (map.containsKey(k * 2) && map.containsKey(k / 2)) mi.add(k);
                else if (map.containsKey(k * 2)) lo.add(k);
                else if (map.containsKey(k / 2)) hi.add(k);
                else return false;
            }
        }
        for (Integer x : lo) {
            Integer v1 = map.get(x);
            Integer v2 = map.get(2 * x);
            if (hi.contains(2 * x)) {
                if (!v1.equals(v2)) return false;
                map.remove(2 * x);
            } else if (mi.contains(2 * x)) {
                if (v2 < v1) return false;
                else if (v2.equals(v1)) map.remove(2 * x);
                else map.put(2 * x, v2 - v1);
            } else return false;
            map.remove(x);
        }
        return dfs(map);
    }

}