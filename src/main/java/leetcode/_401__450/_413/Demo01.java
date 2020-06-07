package leetcode._401__450._413;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 3, 5, 6, 7, 8, 9}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    private int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int[] first = new int[A.length - 1];
        int[] second = new int[first.length - 1];
        for (int i = 1; i < A.length; i++) first[i - 1] = A[i] - A[i - 1];
        for (int i = 1; i < first.length; i++) second[i - 1] = first[i] - first[i - 1];
        int sum = 0;
        for (int i = 0; i < second.length; i++) {
            int count = 1;
            while (second[i] == 0) {
                if (i + 1 < second.length && second[i + 1] == 0) {
                    count++;
                    i++;
                } else {
                    sum += (1 + count) * count / 2;
                    break;
                }
            }
        }
        return sum;
    }

}
