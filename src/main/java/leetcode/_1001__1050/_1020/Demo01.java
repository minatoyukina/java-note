package leetcode._1001__1050._1020;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
        }));
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][n - 1] == 1) dfs(i, n - 1, grid);
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(0, i, grid);
            if (grid[m - 1][i] == 1) dfs(m - 1, i, grid);
        }
        return (int) Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(x -> x == 1).count();
    }

    private void dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return;
        if (grid[x][y] == 1) grid[x][y] = -1;
        dfs(x - 1, y, grid);
        dfs(x + 1, y, grid);
        dfs(x, y - 1, grid);
        dfs(x, y + 1, grid);
    }

}