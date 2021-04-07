package leetcode._851__900._892;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(surfaceArea(new int[][]{{1, 0}, {0, 2}}));
    }

    private int surfaceArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) ans += 2;
                else continue;
                if (i - 1 < 0 || grid[i - 1][j] < grid[i][j]) ans += grid[i][j] - (i - 1 < 0 ? 0 : grid[i - 1][j]);
                if (j - 1 < 0 || grid[i][j - 1] < grid[i][j]) ans += grid[i][j] - (j - 1 < 0 ? 0 : grid[i][j - 1]);
                if (i + 1 >= n || grid[i + 1][j] < grid[i][j]) ans += grid[i][j] - (i + 1 >= n ? 0 : grid[i + 1][j]);
                if (j + 1 >= n || grid[i][j + 1] < grid[i][j]) ans += grid[i][j] - (j + 1 >= n ? 0 : grid[i][j + 1]);

            }
        }
        return ans;
    }

}