package leetcode._1351__1400._1380;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(luckyNumbers(new int[][]{
                {3, 7, 8}, {9, 11, 13}, {15, 16, 17}
        }));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[] rol = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            rol[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                rol[i] = Math.min(rol[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == rol[i] && matrix[i][j] == col[j]) list.add(matrix[i][j]);
        return list;
    }

}