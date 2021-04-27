package leetcode._1__50._32;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("(()(((()"));
        System.out.println(longestValidParentheses("(()()"));
    }

    private int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == (')')) {
                if (s.charAt(i - 1) == '(') dp[i] = (i < 2 ? 0 : dp[i - 2]) + 2;
                else {
                    int pair = i - dp[i - 1] - 1;
                    int pre = pair - 1;
                    if (pair >= 0 && s.charAt(pair) == '(') {
                        dp[i] = dp[i - 1] + 2 + (pre < 0 ? 0 : dp[pre]);
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


}