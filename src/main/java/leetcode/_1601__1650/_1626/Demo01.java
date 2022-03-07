package leetcode._1601__1650._1626;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(bestTeamScore(new int[]{1, 3, 7, 3, 2, 4, 10, 7, 5}, new int[]{4, 5, 2, 1, 1, 2, 4, 1, 4}));
        System.out.println(bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
        System.out.println(bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, max = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{ages[i], scores[i]};
        Arrays.sort(arr, Comparator.<int[]>comparingInt(x -> x[0]).thenComparingInt(x -> x[1]));
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int[] cur = arr[i];
            dp[i] = cur[1];
            for (int j = 0; j < i; j++)
                if (cur[1] >= arr[j][1] || cur[0] == arr[j][0]) dp[i] = Math.max(dp[i], dp[j] + cur[1]);
            max = Math.max(max, dp[i]);

        }
        return max;
    }

}