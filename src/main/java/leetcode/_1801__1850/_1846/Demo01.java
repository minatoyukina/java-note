package leetcode._1801__1850._1846;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
    }

    private int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] + 1)
                arr[i] = arr[i - 1] + 1;
        }
        return arr[arr.length - 1];
    }

}