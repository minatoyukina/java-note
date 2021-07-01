package leetcode._1551__1600._1589;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 1}}));
        System.out.println(maxSumRangeQuery(new int[]{1, 2, 3, 4, 5, 10}, new int[][]{{0, 2}, {1, 3}, {1, 1}}));
    }


    // https://blog.csdn.net/qq_44786250/article/details/100056975
    private int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] count = new int[nums.length];
        for (int[] request : requests) {
            count[request[0]]++;
            if (request[1] + 1 < nums.length) count[request[1] + 1]--;
        }
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        Arrays.sort(count);
        Arrays.sort(nums);
        int sum = 0, mod = (int) 1e9 + 7;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += (long) count[i] * nums[i] % mod;
            sum %= mod;
        }
        return sum;
    }

}