package leetcode._1301__1350._1343;

import org.junit.Test;

import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = IntStream.of(arr).limit(k).sum(), count = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if (sum >= threshold * k) count++;
            if (i + k < arr.length) sum += arr[i + k] - arr[i];
        }
        return count;
    }

}