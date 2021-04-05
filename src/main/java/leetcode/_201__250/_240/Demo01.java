package leetcode._201__250._240;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{
                {-1},
                {-1},
        }, -1));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 4));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}

        }, 5));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (aMatrix[j] == target) return true;
            }
        }
        return false;
    }


}