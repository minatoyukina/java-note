package leetcode._1__50._48;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        int[][] image1 = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        int[][] image2 = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
        rotate(image1);
        rotate(image2);
        System.out.println(Arrays.deepToString(image1));
        System.out.println(Arrays.deepToString(image2));
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;
        int middle = n / 2;
        int tmp;
        for (int i = 0; i < middle; i++) {
            for (int j = 0; j < n - 1 - 2 * i; j++) {
                tmp = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = matrix[i + j][n - 1 - i];
                matrix[i + j][n - 1 - i] = tmp;
            }
        }
    }

}
