package leetcode._1801__1850._1806;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        for (int i = 0; i < 1000; i += 2) {
            System.out.println(reinitializePermutation(i));
        }
    }

    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        int[] ori = arr.clone();
        int count = 0;
        do {
            int[] clone = arr.clone();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) arr[i] = clone[i / 2];
                if (i % 2 == 1) arr[i] = clone[n / 2 + (i - 1) / 2];
            }
            count++;

        } while (!Arrays.equals(ori, arr));
        return count;

    }

}