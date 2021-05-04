package leetcode._351__400._354;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
    }

    private int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(x -> x[0]));
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
