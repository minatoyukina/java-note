package leetcode._951__1000._994;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{0, 1, 1},
                new int[]{1, 0, 1},
        }));
    }

    private int count;

    private int orangesRotting(int[][] grid) {
        if (Arrays.stream(grid).flatMapToInt(Arrays::stream).allMatch(s -> s != 1)) return count;
        boolean flag = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    flag = flag && ((i - 1 < 0 || grid[i - 1][j] < 2)
                            && (j - 1 < 0 || grid[i][j - 1] < 2)
                            && (i + 1 >= grid.length || grid[i + 1][j] < 2)
                            && (j + 1 >= grid[0].length || grid[i][j + 1] < 2));
                }
            }
        }
        if (flag) return -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2 + count) {
                    if (i - 1 >= 0 && grid[i - 1][j] != 0 && grid[i - 1][j] != 2 + count)
                        grid[i - 1][j] = 3 + count;
                    if (j - 1 >= 0 && grid[i][j - 1] != 0 && grid[i][j - 1] != 2 + count)
                        grid[i][j - 1] = 3 + count;
                    if (i + 1 < grid.length && grid[i + 1][j] != 0 && grid[i + 1][j] != 2 + count)
                        grid[i + 1][j] = 3 + count;
                    if (j + 1 < grid[0].length && grid[i][j + 1] != 0 && grid[i][j + 1] != 2 + count)
                        grid[i][j + 1] = 3 + count;
                }
            }
        }
        count++;
        return orangesRotting(grid);
    }

}
