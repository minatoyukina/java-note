package leetcode._1__50._48;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        int[][] image1 = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        int[][] image2 = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
        rotate(image1);
        rotate(image2);
//        System.out.println(Arrays.deepToString(image1));
        System.out.println(Arrays.deepToString(image2));
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;
//        int[][] image = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int tmp;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = tmp;
            }
        }
//        return image;
    }

}
