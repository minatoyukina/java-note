package leetcode._301__350._310;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(findMinHeightTrees(4, new int[][]{
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{1, 3},
        }));
        System.out.println(findMinHeightTrees(6, new int[][]{
                new int[]{0, 3},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{4, 3},
                new int[]{5, 3},
        }));
    }

    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int[] edge : edges) {
                if (edge[0] == i || edge[1] == i) {

                }
            }
        }
        return list;
    }
}
