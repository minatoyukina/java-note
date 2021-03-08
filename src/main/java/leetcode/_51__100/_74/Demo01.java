package leetcode._51__100._74;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }, 14));
        System.out.println(searchMatrix(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }, 1));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> collect = Arrays.stream(matrix).flatMap(s -> Arrays.stream(s).boxed()).collect(Collectors.toList());
        return Collections.binarySearch(collect, target) >= 0;
    }
}
