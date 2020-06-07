package leetcode._451__500._498;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        })));
    }

    private int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int x = 0, y = 0, m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m * n];
        boolean flag = false;
        for (int i = 0; i < m * n; i++) {
            ans[i] = matrix[x][y];
            if (flag) {
                if (!inRange(x + 1, y - 1, matrix)) {
                    if (inRange(x + 1, y, matrix)) x++;
                    else y++;
                    flag = false;
                } else {
                    x++;
                    y--;
                }
            } else {
                if (!inRange(x - 1, y + 1, matrix)) {
                    if (inRange(x, y + 1, matrix)) y++;
                    else x++;
                    flag = true;
                } else {
                    x--;
                    y++;
                }
            }
        }
        return ans;
    }

    private boolean inRange(int x, int y, int[][] matrix) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

}
