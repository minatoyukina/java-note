package leetcode._51__100._73;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                new int[]{0, 0, 0, 5},
                new int[]{4, 3, 1, 4},
                new int[]{0, 1, 1, 4},
                new int[]{1, 2, 1, 3},
                new int[]{0, 0, 1, 1},
        };
        setZeroes(matrix);
        Arrays.stream(matrix).forEach(s -> System.out.println(Arrays.toString(s)));
    }

    private void setZeroes(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int x = 0; x < matrix[i].length; x++) {
                        if (matrix[i][x] == 0) set.add(x);
                        matrix[i][x] = 0;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (set.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
