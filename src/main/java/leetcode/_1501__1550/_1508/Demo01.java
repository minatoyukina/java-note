package leetcode._1501__1550._1508;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int pos = 0;
        int[] arr = new int[n * (n + 1) / 2];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                arr[pos++] = sum;
            }
        }
        Arrays.sort(arr);
        int mod = (int) (1e9 + 7), ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans += arr[i] % mod;
            ans %= mod;
        }
        return ans;
    }

}