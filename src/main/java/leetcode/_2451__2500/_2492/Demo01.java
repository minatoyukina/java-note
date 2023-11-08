package leetcode._2451__2500._2492;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
    }

    public int minScore(int n, int[][] roads) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new HashMap<>()).put(road[1], road[2]);
            map.computeIfAbsent(road[1], k -> new HashMap<>()).put(road[0], road[2]);
        }
        queue.offer(1);
        visited.add(1);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (map.containsKey(x))
                for (Map.Entry<Integer, Integer> entry : map.get(x).entrySet()) {
                    int y = entry.getKey(), d = entry.getValue();
                    min = Math.min(min, d);
                    if (!visited.contains(y)) {
                        queue.offer(y);
                        visited.add(y);
                    }
                }
        }
        return min;
    }

}