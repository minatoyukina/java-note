package leetcode._59;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    private int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
        return matrix;
    }
}
