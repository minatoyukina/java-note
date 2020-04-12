package leetcode._50__100._54;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        }));
        System.out.println(spiralOrder(new int[][]{}));
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (Arrays.deepEquals(matrix, new int[][]{})) return list;
        int direct = 0, x = 0, y = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m * n; i++) {
            if (direct % 4 == 0) {
                if (y == n - direct / 4) {
                    y--;
                    x++;
                    direct++;
                } else list.add(matrix[x][y++]);
            }
            if (direct % 4 == 1) {
                if (x == m - direct / 4) {
                    x--;
                    y--;
                    direct++;
                } else list.add(matrix[x++][y]);
            }
            if (direct % 4 == 2) {
                if (y == -1 + direct / 4) {
                    y++;
                    x--;
                    direct++;
                } else list.add(matrix[x][y--]);
            }
            if (direct % 4 == 3) {
                if (x == direct / 4) {
                    x++;
                    y++;
                    direct++;
                    i--;
                } else list.add(matrix[x--][y]);
            }

        }
        return list;
    }
}
