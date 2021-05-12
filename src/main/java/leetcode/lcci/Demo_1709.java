package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1709 {

    @Test
    public void test() {
        System.out.println(getKthMagicNumber(5));
        System.out.println(getKthMagicNumber(15));
    }

    private int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= k; i++) {
            dp[i] = Math.min(dp[a] * 3, Math.min(dp[b] * 5, dp[c] * 7));
            if (dp[i] == dp[a] * 3) a++;
            if (dp[i] == dp[b] * 5) b++;
            if (dp[i] == dp[c] * 7) c++;
        }
        return dp[k];
    }
}
