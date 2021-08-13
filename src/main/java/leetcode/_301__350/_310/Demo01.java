package leetcode._301__350._310;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(findMinHeightTrees(4, new int[][]{
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{1, 3},
        }));
        System.out.println(findMinHeightTrees(6, new int[][]{
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 4},
                new int[]{5, 4},
        }));
        System.out.println(findMinHeightTrees(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{3, 4},
                new int[]{4, 5},
        }));
    }

    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        Map<Integer, Set<Integer>> map = new ConcurrentHashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            map.computeIfAbsent(x, k -> new HashSet<>());
            map.computeIfAbsent(y, k -> new HashSet<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        while (map.size() > 2) {
            Set<Integer> visited = new HashSet<>();
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                int x = entry.getKey();
                Set<Integer> v = entry.getValue();
                if (v.size() == 1 && !visited.contains(x)) {
                    map.remove(x);
                    int y = v.iterator().next();
                    visited.add(y);
                    map.getOrDefault(y, new HashSet<>()).remove(x);
                }
            }
        }
        return new ArrayList<>(map.keySet());
    }
}
