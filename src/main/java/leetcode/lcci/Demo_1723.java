package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1723 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findSquare(new int[][]{
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
        })));
        System.out.println(Arrays.toString(findSquare(new int[][]{
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1, 1, 1}
        })));
    }

    @SuppressWarnings("all")
    private int[] findSquare(int[][] matrix) {
        int n = matrix.length;
        int ans = 0, x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int l = 1, max = 1;
                    while (i + l < n && j + l < n && matrix[i][j + l] == 0 && matrix[i + l][j] == 0) {
                        boolean flag = true;
                        for (int k = 0; k <= l; k++) {
                            if (i + k >= n || j + k >= n || matrix[i + k][j + l] != 0 || matrix[i + l][j + k] != 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) max = l + 1;
                        l++;
                    }
                    if (max > ans) {
                        ans = max;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        return ans == 0 ? new int[0] : new int[]{x, y, ans};
    }
}
