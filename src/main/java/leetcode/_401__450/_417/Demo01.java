package leetcode._401__450._417;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(pacificAtlantic(new int[][]{
                {1, 1},
                {1, 1},
        }));
    }

    private List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                int m = dfs(heights, i, j, new HashSet<>(), new HashSet<>());
                if (m == 2) {
                    List<Integer> sub = new ArrayList<>(2);
                    sub.add(i);
                    sub.add(j);
                    list.add(sub);
                }
            }
        }
        return list;
    }

    private int dfs(int[][] heights, int x, int y, Set<Integer> set, Set<String> memo) {
        int m = heights.length;
        int n = heights[0].length;
        if (memo.contains(x + "," + y)) return 0;
        memo.add(x + "," + y);
        if (x == 0 || y == 0) set.add(-1);
        if (x == m - 1 || y == n - 1) set.add(1);
        if (inRange(heights, x - 1, y) && heights[x - 1][y] <= heights[x][y]) {
            int s = dfs(heights, x - 1, y, set, memo);
            set.add(s);
        }
        if (inRange(heights, x + 1, y) && heights[x + 1][y] <= heights[x][y]) {
            int s = dfs(heights, x + 1, y, set, memo);
            set.add(s);
        }
        if (inRange(heights, x, y - 1) && heights[x][y - 1] <= heights[x][y]) {
            int s = dfs(heights, x, y - 1, set, memo);
            set.add(s);
        }
        if (inRange(heights, x, y + 1) && heights[x][y + 1] <= heights[x][y]) {
            int s = dfs(heights, x, y + 1, set, memo);
            set.add(s);
        }
        if (set.contains(1) && set.contains(-1)) return 2;
        else if (set.contains(1)) return 1;
        else if (set.contains(-1)) return -1;
        return 0;

    }

    private boolean inRange(int[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

}