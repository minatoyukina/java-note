package leetcode._651__700._661;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{
                {2, 3, 4},
                {5, 6, 7},
                {8, 9, 10},
                {11, 12, 13},
                {14, 15, 16}
        })));

    }

    private int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int valid = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!out(i + x, j + y, m, n)) valid++;
                        ans[i][j] += out(i + x, j + y, m, n) ? 0 : M[i + x][j + y];
                    }
                }
                ans[i][j] /= valid;
            }
        }
        return ans;
    }

    private boolean out(int x, int y, int m, int n) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}
