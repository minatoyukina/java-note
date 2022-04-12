package leetcode._2001__2050._2039;

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
        System.out.println(networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1}));
        System.out.println(networkBecomesIdle(new int[][]{{0, 1}, {0, 2}, {1, 2}}, new int[]{0, 10, 10}));
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(0, 0);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                Set<Integer> set = map.get(poll);
                if (set != null) {
                    for (Integer integer : set) {
                        if (!distance.containsKey(integer)) {
                            distance.put(integer, step);
                            queue.offer(integer);
                        }
                    }
                }
            }
            step++;
        }
        int ans = 0;
        for (int i = 1; i < patience.length; i++) {
            int d = distance.get(i);
            ans = Math.max(ans, (d * 2 - 1) / patience[i] * patience[i] + d * 2);
        }
        return ans + 1;
    }
}
