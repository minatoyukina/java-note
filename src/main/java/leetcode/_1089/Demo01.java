package leetcode._1089;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
//        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
//        int[] arr = {0, 1, 7, 6, 0, 2, 0, 7};
//        int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
        int[] arr = {
                9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0,
                9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0,
                2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1,
                3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9,
                6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3,
                7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

    }

    private void duplicateZeros(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && count < arr.length - i) count++;
        }
        for (int i = arr.length - 1; i >= count; i--) {
            if (arr[i - count] == 0) {
                arr[i] = 0;
                arr[i - 1] = 0;
                i--;
                count--;

            } else arr[i] = arr[i - count];
        }
        if (count != 0) {
            arr[arr.length - 1] = 0;
            System.arraycopy(arr, 1, arr, 0, arr.length - 2);
        }

    }

}
