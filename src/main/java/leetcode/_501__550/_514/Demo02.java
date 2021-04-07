package leetcode._501__550._514;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(findRotateSteps("ababcab", "acbaacba"));
        System.out.println(findRotateSteps("godding", "gd"));
    }


    private int findRotateSteps(String ring, String key) {
        int y = ring.length(), x = key.length();
        int[][] dp = new int[x + 1][y];
        for (int i = x - 1; i >= 0; i--) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || ring.charAt(j) == key.charAt(i - 1)) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < y; k++) {
                        if (ring.charAt(k) == key.charAt(i)) {
                            int step = Math.min(Math.abs(j - k), y - Math.abs(j - k));
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + step + 1);
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }
}