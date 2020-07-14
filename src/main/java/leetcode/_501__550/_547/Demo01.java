package leetcode._501__550._547;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findCircleNum(new int[][]{
                new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 0},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 1}
        }));
        System.out.println(findCircleNum(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 1}
        }));

    }

    private int total;

    private int findCircleNum(int[][] M) {
        total = M.length;
        int[] arr = new int[M.length];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (M[i][j] == 1) {
                    merge(arr, i, j);
                }
            }
        }
        return total;
    }

    private int find(int[] arr, int x) {
        return arr[x] == x ? x : (arr[x] = find(arr, arr[x]));
    }

    private void merge(int arr[], int i, int j) {
        int x = arr[find(arr, i)];
        int y = arr[find(arr, j)];
        if (x != y) {
            arr[find(arr, i)] = y;
            total--;
        }
    }

}
