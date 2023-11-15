package leetcode._1301__1350._1334;

import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTheCity(5, Common.strToArray("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]"), 2));
        System.out.println(findTheCity(6, Common.strToArray("[[0,1,10],[0,2,1],[2,3,1],[1,3,1],[1,4,1],[4,5,10]]"), 20));
        System.out.println(findTheCity(4, Common.strToArray("[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]"), 4));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
            map.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
        }
        int min = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < n; i++) {
            int bfs = bfs(i, map, distanceThreshold);
            if (bfs <= min) {
                ans = i;
                min = bfs;
            }
        }
        return ans;
    }


    private int bfs(int x, Map<Integer, Map<Integer, Integer>> map, int distanceThreshold) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        Map<Integer, Integer> visited = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0], b = poll[1];
            Map<Integer, Integer> sub = map.getOrDefault(a, Collections.emptyMap());
            for (Map.Entry<Integer, Integer> entry : sub.entrySet()) {
                int k = entry.getKey(), v = entry.getValue();
                if (b + v <= distanceThreshold) {
                    set.add(k);
                    if (visited.getOrDefault(k, Integer.MAX_VALUE) > b + v) {
                        visited.put(k, b + v);
                        queue.offer(new int[]{k, b + v});
                    }
                }
            }
        }
        return set.size() - (set.contains(x) ? 1 : 0);
    }

}