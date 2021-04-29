package leetcode._401__450._403;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canCross(new int[]{0, 1}));
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    private Map<Integer, Map<Integer, Boolean>> map;

    private boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>();
        map = new HashMap<>();
        for (int stone : stones) set.add(stone);
        return dfs(set, 0, 1, stones[stones.length - 1]);
    }

    private boolean dfs(Set<Integer> set, int index, int k, int last) {
        Boolean flag = map.getOrDefault(index, new HashMap<>()).getOrDefault(k, null);
        if (flag != null) return flag;
        if (index == last) return true;
        if (index > last || k <= 0 || !set.contains(index)) return false;
        boolean b = dfs(set, index + k - 1, k - 1, last) ||
                dfs(set, index + k, k, last) ||
                (index > 0 && dfs(set, index + k + 1, k + 1, last));
        Map<Integer, Boolean> sub = new HashMap<>();
        sub.put(k, b);
        map.put(index, sub);
        return b;
    }

}