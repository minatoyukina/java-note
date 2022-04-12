package leetcode._1001__1050._1034;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(colorBorder(new int[][]{{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}}, 1, 3, 1)));
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(row, col, grid, grid[row][col], new boolean[grid.length][grid[0].length]);
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 0) grid[i][j] = color;
        return grid;
    }

    private void dfs(int x, int y, int[][] grid, int ori, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || grid[x][y] != ori) return;
        if (x == 0 || y == 0 || x == m - 1 || y == n - 1 || check(x, y, grid, ori)) grid[x][y] = 0;
        visited[x][y] = true;
        dfs(x - 1, y, grid, ori, visited);
        dfs(x + 1, y, grid, ori, visited);
        dfs(x, y - 1, grid, ori, visited);
        dfs(x, y + 1, grid, ori, visited);
    }

    private boolean check(int x, int y, int[][] grid, int ori) {
        return (grid[x - 1][y] != ori && grid[x - 1][y] != 0) ||
                (grid[x + 1][y] != ori && grid[x + 1][y] != 0) ||
                (grid[x][y - 1] != ori && grid[x][y - 1] != 0) ||
                (grid[x][y + 1] != ori && grid[x][y + 1] != 0);
    }

}