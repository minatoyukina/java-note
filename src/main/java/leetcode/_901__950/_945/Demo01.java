package leetcode._901__950._945;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    private int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                count += A[i] + 1 - A[i + 1];
                A[i + 1] = A[i] + 1;
            }
        }
        return count;
    }

}
