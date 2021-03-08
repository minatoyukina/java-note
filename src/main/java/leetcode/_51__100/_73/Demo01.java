package leetcode._51__100._73;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                new int[]{0, 0, 0, 5},
                new int[]{4, 3, 1, 4},
                new int[]{0, 1, 1, 4},
                new int[]{1, 2, 1, 3},
                new int[]{0, 0, 1, 1},
        };
        setZeroes(matrix);
        Arrays.stream(matrix).forEach(s -> System.out.println(Arrays.toString(s)));
    }

    private void setZeroes(int[][] matrix) {
        int a = Integer.MIN_VALUE, b = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int x = 0; x < i; x++) {
                        matrix[x][j] = 0;
                    }
                    for (int y = 0; y < j; y++) {
                        matrix[i][y] = 0;
                    }
                    if (i < matrix.length - 1) {
                        if (matrix[i + 1][j] != 0) {
                            matrix[i + 1][j] = a;
                        }
                    }
                    if (j < matrix[i].length - 1) {
                        if (matrix[i][j + 1] != 0) {
                            matrix[i][j + 1] = b;
                        }
                    }
                }
                if (matrix[i][j] == a) {
                    matrix[i][j] = 0;
                    if (i < matrix.length - 1 && matrix[i + 1][j] != 0) {
                        matrix[i + 1][j] = a;
                    }
                }
                if (matrix[i][j] == b) {
                    matrix[i][j] = 0;
                    if (j < matrix[i].length - 1 && matrix[i][j + 1] != 0) {
                        matrix[i][j + 1] = b;
                    }
                }


            }
        }
    }
}
