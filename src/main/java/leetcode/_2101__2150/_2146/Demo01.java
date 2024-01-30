package leetcode._2101__2150._2146;

import leetcode.util.Common;
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
        System.out.println(highestRankedKItems(Common.strToArray("[[1,2,0,1],[1,3,3,1],[0,2,5,1]]"), new int[]{2, 3}, new int[]{2, 3}, 2));
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], grid[start[0]][start[1]]});
        List<List<Integer>> list = new ArrayList<>();
        Set<Long> visited = new HashSet<>();
        visited.add(start[0] * 100000L + start[1]);
        while (!queue.isEmpty()) {
            int size = queue.size();
            queue.sort(Comparator.<int[]>comparingInt(x -> x[2]).thenComparingInt(x -> x[0]).thenComparingInt(x -> x[1]));
            for (int i = 0; i < size; i++) {
                if (list.size() == k) return list;
                int[] arr = queue.poll();
                assert arr != null;
                int x = arr[0], y = arr[1], p = arr[2];
                if (p >= pricing[0] && p <= pricing[1]) list.add(Arrays.asList(x, y));
                for (int u = -1; u <= 1; u++) {
                    for (int v = -1; v <= 1; v++) {
                        if (u * v != 0 || u + v == 0) continue;
                        int a = x + u, b = y + v;
                        long hash = a * 100000L + b;
                        if (a >= 0 && b >= 0 && a < m && b < n && grid[a][b] > 0 && visited.add(hash))
                            queue.offer(new int[]{a, b, grid[a][b]});
                    }
                }
            }
        }
        return list;
    }

}
