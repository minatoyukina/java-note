package leetcode._1951__2000._1975;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxMatrixSum(new int[][]{
                {1, 2, 3},
                {-1, -2, -3},
                {1, 2, 3}
        }));
    }

    public long maxMatrixSum(int[][] matrix) {
        long neg = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int[] ints : matrix) {
            for (int i : ints) {
                if (i < 0) neg++;
                min = Math.min(min, Math.abs(i));
                sum += Math.abs(i);
            }
        }
        return neg % 2 == 0 ? sum : (sum - 2 * min);
    }

}