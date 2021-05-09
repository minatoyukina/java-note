package leetcode._1451__1500._1482;

import org.junit.Test;

import java.util.stream.IntStream;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }


    private int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;
        int right = IntStream.of(bloomDay).max().orElse(0);
        int left = IntStream.of(bloomDay).min().orElse(0);
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(bloomDay, m, k, mid)) {
                right = mid;
            } else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] bloomDay, int m, int k, int day) {
        int ans = 0, count = 0;
        for (int i : bloomDay) {
            if (i <= day) count++;
            else count = 0;
            if (count == k) {
                ans++;
                count = 0;
            }
            if (ans == m) return true;
        }
        return false;
    }

}
