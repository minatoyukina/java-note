package leetcode._301__350._319;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(bulbSwitch(0));
        System.out.println(bulbSwitch(1000000));
    }

    private int bulbSwitch(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (getFactors(i) % 2 == 1 ? 1 : 0);
        }
        return dp[n];
    }

    private int getFactors(int n) {
        int x = (int) Math.sqrt(n);
        int count = 0;
        for (int i = 1; i <= x; i++) {
            if (n % i == 0) count += 2;
        }
        return count + (x * x == n ? -1 : 0);
    }
}