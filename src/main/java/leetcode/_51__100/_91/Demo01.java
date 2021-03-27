package leetcode._51__100._91;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("27"));
    }


    private int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        dp[s.length()] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') dp[i] = 0;
            else if (c == '1' || c == '2') {
                char c1 = s.charAt(i + 1);
                if (c1 == '0') dp[i] = dp[i + 2];
                else if ((c == '2' && c1 > '6')) dp[i] = dp[i + 1];
                else dp[i] = dp[i + 1] + dp[i + 2];
            } else dp[i] = dp[i + 1];
        }
        return dp[0];
    }
}
