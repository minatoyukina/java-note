package leetcode._1391;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(hasValidPath(new int[][]{
                new int[]{6, 1, 3},
                new int[]{4, 1, 5},
        }));
        System.out.println(hasValidPath(new int[][]{
                new int[]{4, 1},
                new int[]{6, 1},
        }));
    }

    private boolean hasValidPath(int[][] grid) {
        int[] s1 = new int[]{1, 3};
        int[] s2 = new int[]{2, 4};
        int[] s3 = new int[]{1, 4};
        int[] s4 = new int[]{3, 4};
        int[] s5 = new int[]{1, 2};
        int[] s6 = new int[]{2, 3};
        int[][] ss = new int[][]{s1, s2, s3, s4, s5, s6};
        int x = 0, y = 0;
        int start = ss[grid[x][y] - 1][0];
        int end = ss[grid[x][y] - 1][1];
        return test(grid, ss, start, end) || test(grid, ss, end, start);
    }

    private boolean test(int[][] grid, int[][] ss, int start, int end) {
        int n = grid.length * grid[0].length;
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(x + "-" + y);
            int[] s;
            try {
                s = ss[grid[x][y] - 1];
            } catch (Exception e) {
                return set.contains(grid.length - 1 + "-" + (grid[0].length - 1));
            }
            if (i > 0 && s[0] != start && s[1] != start) return false;
            if (i > 0) {
                if (start == s[0]) {
                    end = s[1];
                } else {
                    end = s[0];
                }
            }
            if (end == 1) y--;
            if (end == 2) x--;
            if (end == 3) y++;
            if (end == 4) x++;
            start = end > 2 ? end - 2 : end + 2;
        }
        return set.contains(grid.length - 1 + "-" + (grid[0].length - 1));
    }
}
