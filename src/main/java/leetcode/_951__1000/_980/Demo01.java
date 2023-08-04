package leetcode._951__1000._980;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(uniquePathsIII(Common.strToArray("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]")));
        System.out.println(uniquePathsIII(Common.strToArray("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]")));
    }

    public int uniquePathsIII(int[][] grid) {
        int cnt = 0, x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                } else if (grid[i][j] == 0) cnt++;
            }
        }
        return dfs(grid, x, y, cnt, new HashSet<>(Collections.singletonList(x * 100 + y)));
    }

    private int dfs(int[][] grid, int x, int y, int cnt, Set<Integer> visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) return 0;
        if (grid[x][y] == 2 && cnt == -1) return 1;
        int[][] arr = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int hash = 100 * (x + arr[i][0]) + y + arr[i][1];
            if (visited.add(hash)) {
                cnt--;
                sum += dfs(grid, x + arr[i][0], y + arr[i][1], cnt++, visited);
                visited.remove(hash);
            }
        }
        return sum;
    }
}