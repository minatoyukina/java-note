package leetcode._540;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        })));

    }

    private int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

            }
        }
        return matrix;
    }

}
