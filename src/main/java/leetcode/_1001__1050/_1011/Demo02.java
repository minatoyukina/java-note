package leetcode._1001__1050._1011;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(shipWithinDays(new int[]{488, 247, 151, 268, 358, 270, 366, 2, 85, 49, 209, 37, 353, 17, 287,
                385, 421, 467, 32, 201, 398, 27, 108, 291, 435, 447}, 26));
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    private int shipWithinDays(int[] weights, int D) {
        int[] preSum = new int[weights.length + 1];
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            preSum[i + 1] = preSum[i] + weights[i];
            max = Math.max(max, weights[i]);
        }
        int[][] dp = new int[weights.length][D];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < D; j++) {
                if (j == 0) dp[i][j] = preSum[i + 1];
                else {
                    for (int k = i - 1; k >= 0; k--) {
                        int sum = preSum[i + 1] - preSum[k + 1];
                        dp[i][j] = dp[i][j] == 0 ?
                                Math.max(sum, dp[k][j - 1]) :
                                Math.min(dp[i][j], Math.max(sum, dp[k][j - 1]));
                        if (dp[i][j] < max) dp[i][j] = max;
                    }
                }

            }
        }
        return dp[weights.length - 1][D - 1];
    }

}