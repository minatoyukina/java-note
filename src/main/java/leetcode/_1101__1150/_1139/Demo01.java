package leetcode._1101__1150._1139;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largest1BorderedSquare(new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 0},
        }));
    }

    private int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                for (int k = 0; k < Math.min(m - i, n - j); k++)
                    if (check(i, j, i + k, j + k, grid)) max = Math.max((k + 1) * (k + 1), max);
            }
        }
        return max;
    }

    private boolean check(int x1, int y1, int x2, int y2, int[][] grid) {
        for (int i = x1; i <= x2; i++) if (grid[i][y1] != 1 || grid[i][y2] != 1) return false;
        for (int i = y1; i <= y2; i++) if (grid[x1][i] != 1 || grid[x2][i] != 1) return false;
        return true;
    }
}