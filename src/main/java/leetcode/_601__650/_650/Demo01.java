package leetcode._601__650._650;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSteps(3));
        System.out.println(minSteps(8));
    }

    private int minSteps(int n) {
        if (n < 2) return 2;
        int[] dp = new int[n];
        dp[0] = 2;
        dp[1] = 3;
        for (int i = 2; i < n; i++) {
            int x = i / 2;
            int tmp = 0;
            for (int j = 0; j < x; j++) {
                if (j == x / 2) tmp = Math.max(tmp, dp[j] + 2);
                else tmp = Math.max(tmp, dp[j] + 1);
            }
            dp[i] = tmp;
        }
        return dp[n - 1];
    }


}
