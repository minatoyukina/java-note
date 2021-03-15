package leetcode._51__100._96;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }

    private int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;

        }
        return dp[n];
    }

}
