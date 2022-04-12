package leetcode._1201__1250._1219;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(getMaximumGold(new int[][]{
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        }));
    }

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) ans = Math.max(ans, dfs(grid, i, j, new HashSet<>()));
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y, Set<Integer> visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || visited.contains(x * 1000 + y)) {
            return 0;
        }
        visited.add(x * 1000 + y);
        int d1 = dfs(grid, x - 1, y, new HashSet<>(visited));
        int d2 = dfs(grid, x + 1, y, new HashSet<>(visited));
        int d3 = dfs(grid, x, y - 1, new HashSet<>(visited));
        int d4 = dfs(grid, x, y + 1, new HashSet<>(visited));
        return grid[x][y] + Math.max(Math.max(d1, d2), Math.max(d3, d4));
    }

}