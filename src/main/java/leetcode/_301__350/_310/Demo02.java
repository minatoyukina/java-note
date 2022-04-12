package leetcode._301__350._310;

import org.junit.Test;

import java.util.*;

public class Demo02 {

    @Test
    public void test() {
        System.out.println(findMinHeightTrees(6, new int[][]{
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 4},
                new int[]{5, 4},
        }));
        System.out.println(findMinHeightTrees(4, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
        }));
    }

    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            map.computeIfAbsent(x, k -> new HashSet<>()).add(y);
            map.computeIfAbsent(y, k -> new HashSet<>()).add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int x = entry.getKey();
            if (entry.getValue().size() == 1) {
                queue.add(x);
                visited.add(x);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (visited.size() == n) return new ArrayList<>(queue);
            while (size-- > 0) {
                Integer poll = queue.poll();
                Set<Integer> set = map.getOrDefault(poll, new HashSet<>());
                for (Integer integer : set) {
                    Set<Integer> integers = map.getOrDefault(integer, new HashSet<>());
                    integers.remove(poll);
                    if (integers.size() == 1) {
                        Integer next = set.iterator().next();
                        if (visited.contains(next)) continue;
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return Collections.singletonList(0);
    }
}
