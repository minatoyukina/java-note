package leetcode._2301__2350._2316;

import leetcode.util.Common;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(countPairs(12, new int[][]{}));
        System.out.println(countPairs(7, Common.strToArray("[[0,2],[0,5],[2,4],[1,6],[5,4]]")));
    }

    private long countPairs(int n, int[][] edges) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        for (int[] edge : edges) union(arr, edge[0], edge[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = find(arr, i);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return map.values().stream().mapToLong(x -> (n - x) * (long) x).reduce(Long::sum).orElse(0) / 2;
    }

    private int find(int[] arr, int target) {
        return arr[target] == target ? target : (arr[target] = find(arr, arr[target]));
    }

    private void union(int[] arr, int x, int y) {
        int a = find(arr, x), b = find(arr, y);
        if (a != b) arr[a] = b;
    }

}
