package leetcode._1551__1600._1568;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[] pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        int sum = 0;
        for (int step = 1; step <= arr.length; step += 2) {
            for (int i = 0; i <= arr.length - step; i++) {
                sum += pre[i + step] - pre[i];
            }
        }
        return sum;
    }
}