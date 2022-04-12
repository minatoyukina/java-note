package leetcode._1701__1750._1706;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findBall(new int[][]{
                {1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}
        })));
        System.out.println(Arrays.toString(findBall(new int[][]{
                {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}
        })));
    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = dfs(0, i, grid);
        return ans;
    }

    private int dfs(int x, int y, int[][] grid) {
        if (x == grid.length) return y;
        int i = grid[x][y];
        if (i == -1) return y == 0 || grid[x][y - 1] == 1 ? -1 : dfs(x + 1, y - 1, grid);
        return y == grid[0].length - 1 || grid[x][y + 1] == -1 ? -1 : dfs(x + 1, y + 1, grid);
    }

}