package leetcode._1001__1050._1049;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
        System.out.println(lastStoneWeightII(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 14, 23, 37, 61, 98}));
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeightII(new int[]{1, 1}));
    }

    private int lastStoneWeightII(int[] stones) {
        min = Integer.MAX_VALUE;
        map = new HashMap<>();
        dfs(stones, 0, 0);
        return min;
    }

    private int min;
    private Map<Integer, Set<Integer>> map;

    private void dfs(int[] stones, int index, int sum) {
        if (index >= stones.length) {
            if (sum >= 0) min = Math.min(min, sum);
            return;
        }
        Set<Integer> set = map.getOrDefault(index, new HashSet<>());
        map.put(index, set);
        if (!set.contains(sum + stones[index])) {
            set.add(sum + stones[index]);
            dfs(stones, index + 1, sum + stones[index]);
        }
        if (!set.contains(sum - stones[index])) {
            set.add(sum - stones[index]);
            dfs(stones, index + 1, sum - stones[index]);
        }
    }
}