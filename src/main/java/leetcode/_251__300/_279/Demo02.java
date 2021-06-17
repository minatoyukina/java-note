package leetcode._251__300._279;

import org.junit.Test;

import java.util.Arrays;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(numSquares(1));
        System.out.println(numSquares(18));
    }

    private int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 4);
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
