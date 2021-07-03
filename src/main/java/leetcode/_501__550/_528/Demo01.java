package leetcode._501__550._528;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        Solution solution = new Solution(new int[]{1, 3, 1});
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pickIndex());
        }
    }

    @SuppressWarnings("all")
    class Solution {

        private int[] arr;
        private int sum;

        public Solution(int[] w) {
            sum = IntStream.of(w).sum();
            arr = new int[w.length];
            arr[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                arr[i] = arr[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int i = new Random().nextInt(sum);
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] == i) return mid + 1;
                else if (arr[mid] > i) right = mid;
                else left = mid + 1;
            }
            return left;
        }
    }

}