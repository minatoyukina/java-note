package leetcode._151__200._200;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        char[][] chars = {
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'},
        };
        System.out.println(numIslands(chars));
    }

    private int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (dfs(grid, set, i, j, false)) count++;
        return count;
    }

    private boolean dfs(char[][] grid, Set<String> set, int x, int y, boolean flag) {
        String s = x + "," + y;
        if (flag && (!inRange(grid, x, y) || grid[x][y] == '0' || set.contains(s))) return true;
        if (grid[x][y] == '1' && !set.contains(s)) {
            set.add(s);
            return dfs(grid, set, x - 1, y, true)
                    && dfs(grid, set, x + 1, y, true)
                    && dfs(grid, set, x, y - 1, true)
                    && dfs(grid, set, x, y + 1, true);
        }
        return false;
    }

    private boolean inRange(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
