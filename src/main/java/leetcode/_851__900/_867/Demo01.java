package leetcode._851__900._867;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) res[i][j] = matrix[j][i];
        return res;
    }
}