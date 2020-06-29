package leetcode._1252;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(oddCells(2, 3, new int[][]{new int[]{0, 1}, new int[]{1, 1}}));
        System.out.println(oddCells(3, 4, new int[][]{new int[]{0, 1}, new int[]{1, 1}}));
    }

    private int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                matrix[index[0]][i]++;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][index[1]]++;
            }
        }
        int ans = 0;
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                if (anAMatrix % 2 == 1) ans++;
            }
        }
        return ans;
    }
}
