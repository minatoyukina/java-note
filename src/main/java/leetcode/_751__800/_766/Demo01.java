package leetcode._751__800._766;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }

    private boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int x = i, y = 0;
            while (x < m && y < n) if (matrix[x++][y++] != matrix[i][0]) return false;
        }
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            while (x < m && y < n) if (matrix[x++][y++] != matrix[0][i]) return false;
        }
        return true;
    }


}