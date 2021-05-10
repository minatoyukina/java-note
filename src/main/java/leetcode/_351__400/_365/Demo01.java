package leetcode._351__400._365;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canMeasureWater(5, 3, 4));
        System.out.println(canMeasureWater(2, 6, 5));
    }

    private boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        dp = new HashMap<>();
        return dfs(jug1Capacity, jug2Capacity, 0, 0, targetCapacity);
    }

    private Map<Integer, Set<Integer>> dp;

    private boolean dfs(int c1, int c2, int w1, int w2, int t) {
        if (dp.getOrDefault(w1, new HashSet<>()).contains(w2)) return false;
        Set<Integer> set = dp.getOrDefault(w1, new HashSet<>());
        set.add(w2);
        dp.put(w1, set);
        if (w1 == t || w2 == t || w1 + w2 == t) return true;
        return dfs(c1, c2, c1, w2, t) ||
                dfs(c1, c2, w1, c2, t) ||
                dfs(c1, c2, 0, w2, t) ||
                dfs(c1, c2, w1, 0, t) ||
                (w1 > c2 - w2 ? dfs(c1, c2, w1 - (c2 - w2), c2, t) : dfs(c1, c2, 0, w1 + w2, t)) ||
                (w2 > c1 - w1 ? dfs(c1, c2, c1, w2 - (c1 - w1), t) : dfs(c1, c2, w1 + w2, 0, t));
    }

}