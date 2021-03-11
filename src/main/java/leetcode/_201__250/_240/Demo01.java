package leetcode._201__250._240;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{
                {1, 1},

        }, 13));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}

        }, 5));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 7));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        int r1 = matrix.length - 1;
        int r2 = matrix[0].length - 1;
        int l1 = 0, l2 = 0;
        while (r1 <= l1 || l2 <= r2) {
            if (r2 <= l2 + 1 || r1 <= l1 + 1) {
                for (int[] aMatrix : matrix) {
                    for (int i = l2; i <= r2; i++) {
                        if (aMatrix[i] == target) return true;
                    }
                }
                for (int i = l1; i <= r1; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[i][j] == target) return true;
                    }
                }
                return false;
            }
            int m1 = l1 + (r1 - l1) / 2;
            int m2 = l2 + (r2 - l2) / 2;
            if (matrix[m1][m2] > target) {
                r1 = m1;
                if (l1 == r1) r2 = m2;
            } else if (matrix[m1][m2] < target) {
                if (l2 == r2) l1 = m1;
                l2 = m2;
            } else return true;
        }
        return false;
    }

}