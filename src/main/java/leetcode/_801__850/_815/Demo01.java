package leetcode._801__850._815;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        System.out.println(numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 1));
    }

    private int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int x = 0; x < routes.length; x++) {
            int[] route = routes[x];
            for (int i : route) {
                Set<Integer> set = map.getOrDefault(i, new HashSet<>());
                set.add(x);
                map.put(i, set);
            }
        }
        if (!map.containsKey(source) || !map.containsKey(target)) return -1;
        if (source == target) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(map.get(source));
        boolean[] visited = new boolean[routes.length];
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer index = queue.poll();
                assert index != null;
                if (map.get(target).contains(index)) return step;
                for (int i : routes[index]) {
                    Set<Integer> set = map.getOrDefault(i, new HashSet<>());
                    for (Integer j : set) {
                        if (!visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}