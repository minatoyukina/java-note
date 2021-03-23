package leetcode._51__100._84;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{0, 9}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        int[] dp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i]);
            dp[i] = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                dp[i] = Math.min(dp[i], heights[j]);
                ans = Math.max(ans, (j - i + 1) * dp[i]);
            }
        }
        return ans;
    }
}
