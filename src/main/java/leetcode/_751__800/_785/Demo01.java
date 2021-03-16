package leetcode._751__800._785;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isBipartite(new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2},
        }));
        System.out.println(isBipartite(new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2},
        }));
    }

    private boolean isBipartite(int[][] graph) {
        boolean[] dp = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isOddRing(graph, i, new HashMap<>(), dp)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOddRing(int[][] graph, int index, Map<Integer, Integer> map, boolean[] dp) {
        if (dp[index]) return false;
        int size = map.size();
        map.put(index, size);
        int[] arr = graph[index];
        for (int i : arr) {
            if (!map.containsKey(i)) {
                if (isOddRing(graph, i, new HashMap<>(map), dp)) {
                    return true;
                }
            } else {
                int length = map.size() - map.get(i);
                if (length > 2 && length % 2 == 1) {
                    return true;
                }
            }
        }
        for (int i : map.keySet()) dp[i] = true;
        return false;
    }

}