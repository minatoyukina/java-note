package leetcode._50__100._59;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        Arrays.stream(generateMatrix(4)).forEach(s -> System.out.println(Arrays.toString(s)));
        Arrays.stream(generateMatrix(5)).forEach(s -> System.out.println(Arrays.toString(s)));
    }

    private int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int direct = 0, x = 0, y = 0;
        for (int i = 1; i <= n * n; i++) {
            if (direct % 4 == 0) {
                if (y == n || matrix[x][y] != 0) {
                    y--;
                    x++;
                    direct++;
                } else matrix[x][y++] = i;
            }
            if (direct % 4 == 1) {
                if (x == n || matrix[x][y] != 0) {
                    x--;
                    y--;
                    direct++;
                } else matrix[x++][y] = i;
            }
            if (direct % 4 == 2) {
                if (y == -1 || matrix[x][y] != 0) {
                    y++;
                    x--;
                    direct++;
                } else matrix[x][y--] = i;
            }
            if (direct % 4 == 3) {
                if (x == -1 || matrix[x][y] != 0) {
                    x++;
                    y++;
                    direct++;
                    i--;
                } else matrix[x--][y] = i;
            }
        }
        return matrix;
    }
}
