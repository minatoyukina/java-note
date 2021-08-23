package leetcode._751__800._787;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findCheapestPrice(1, new int[][]{
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        }, 0, 2, 0));
        System.out.println(findCheapestPrice(4, new int[][]{
                {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}
        }, 0, 3, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int[] flight : flights) {
            Set<Pair<Integer, Integer>> pairs = map.computeIfAbsent(flight[0], k1 -> new HashSet<>());
            pairs.add(new Pair<>(flight[1], flight[2]));
        }
        Map<Integer, Integer> cost = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        cost.put(src, 0);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            if (k < 0) break;
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                assert poll != null;
                Set<Pair<Integer, Integer>> set = map.getOrDefault(poll, new HashSet<>());
                for (Pair<Integer, Integer> pair : set) {
                    int x = pair.getKey(), y = pair.getValue();
                    if (x == dst) min = Math.min(min, cost.get(poll) + y);
                    else queue.offer(x);
                    cost.put(x, cost.get(poll) + y);
                }
            }
            k--;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}