package leetcode._651__700._684;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{
                new int[]{2, 3},
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{4, 6},
        })));
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3},
        })));

    }

    private int[] arr;

    private int[] findRedundantConnection(int[][] edges) {
        arr = new int[edges.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                if (edges[i][0] == edges[j][0]
                        || edges[i][1] == edges[j][0]
                        || edges[i][0] == edges[j][1]) {
                    merge(i, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) return edges[i];
        }
        return edges[edges.length - 1];
    }

    private int find(int x) {
        return arr[x] == x ? x : (arr[x] = find(arr[x]));
    }

    private void merge(int i, int j) {
        arr[find(i)] = find(j);
    }
}
