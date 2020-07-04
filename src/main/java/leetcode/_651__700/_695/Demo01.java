package leetcode._651__700._695;

import org.junit.Test;

public class Demo01 {

    private static int count = 0;


    @Test
    public void test() {
        System.out.println(maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }

    private int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    ans = Math.max(ans, count);
                    count = 0;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
            if (grid[x][y] == 1) {
                count++;
                grid[x][y] = -1;
                dfs(grid, x - 1, y);
                dfs(grid, x + 1, y);
                dfs(grid, x, y - 1);
                dfs(grid, x, y + 1);
            }
        }
    }

}
