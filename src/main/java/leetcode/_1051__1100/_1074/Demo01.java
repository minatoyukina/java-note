package leetcode._1051__1100._1074;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSubmatrixSumTarget(new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        }, 0));
        System.out.println(numSubmatrixSumTarget(new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        }, 1));
    }

    private int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i + 1][j + 1] = pre[i + 1][j] + pre[i][j + 1] + matrix[i][j] - pre[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = i + 1; k <= m; k++) {
                    for (int l = j + 1; l <= n; l++) {
                        if (pre[k][l] + pre[i][j] - pre[i][l] - pre[k][j] == target) ans++;
                    }
                }
            }
        }
        return ans;
    }

}