package leetcode._50__100._96;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }

    private int numTrees(int n) {
        int[] dp = new int[Integer.MAX_VALUE];
        dp[0] = 1;
        dp[1] = 2;
        return dp[n];
    }

}
