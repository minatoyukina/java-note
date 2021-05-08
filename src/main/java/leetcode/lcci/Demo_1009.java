package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1009 {

    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{{}}, 0));
        System.out.println(searchMatrix(new int[][]{
                {1, 2, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 5));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) return true;
            if (target > matrix[x][y]) x++;
            else y--;
        }
        return false;
    }
}
