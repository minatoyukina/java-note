package leetcode._501__550._542;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{
                        new int[]{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        new int[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        new int[]{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        new int[]{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
                }
        )));
    }


    private int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            label:
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                    continue;
                }
                Queue<int[]> queue = new LinkedList<>();
                Set<String> set = new HashSet<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0], y = poll[1];
                    set.add(x + "=" + y);
                    if (x - 1 >= 0 && !set.contains(x - 1 + "=" + y)) {
                        if (matrix[x - 1][y] == 0) {
                            ans[i][j] = Math.abs(x - 1 - i) + Math.abs(y - j);
                            continue label;
                        }
                        queue.add(new int[]{x - 1, y});
                    }
                    if (x + 1 < m && !set.contains(x + 1 + "=" + y)) {
                        if (matrix[x + 1][y] == 0) {
                            ans[i][j] = Math.abs(x + 1 - i) + Math.abs(y - j);
                            continue label;
                        }
                        queue.add(new int[]{x + 1, y});
                    }
                    if (y - 1 >= 0 && !set.contains(x + "=" + (y - 1))) {
                        if (matrix[x][y - 1] == 0) {
                            ans[i][j] = Math.abs(x - i) + Math.abs(y - 1 - j);
                            continue label;
                        }
                        queue.add(new int[]{x, y - 1});
                    }
                    if (y + 1 < n && !set.contains(x + "=" + (y + 1))) {
                        if (matrix[x][y + 1] == 0) {
                            ans[i][j] = Math.abs(x - i) + Math.abs(y + 1 - j);
                            continue label;
                        }
                        queue.add(new int[]{x, y + 1});
                    }
                }
            }
        }
        return ans;
    }
}
