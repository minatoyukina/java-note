package leetcode._1601__1650._1641;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(33));
    }

    private int countVowelStrings(int n) {
        int[][] dp = new int[6][n + 1];
        for (int i = 1; i <= 5; i++) dp[i][1] = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 2; j <= n; j++) {
                for (int k = 1; k <= i; k++) {
                    dp[i][j] += dp[k][j - 1];
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= 5; i++) sum += dp[i][n];
        return sum;
    }


}