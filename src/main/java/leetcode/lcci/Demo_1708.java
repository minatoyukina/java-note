package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1708 {

    @Test
    public void test() {
        System.out.println(bestSeqAtIndex(new int[]{65, 70, 56, 75, 60, 68}, new int[]{100, 150, 90, 190, 95, 110}));
        System.out.println(bestSeqAtIndex(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}));
    }

    private int bestSeqAtIndex(int[] height, int[] weight) {
        if (height.length == 0) return 0;
        int[][] arr = new int[height.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = height[i];
            arr[i][1] = weight[i];
        }
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        Arrays.sort(arr, (x, y) -> {
            if (x[0] == y[0]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });
        int max = 0;
        for (int i = 0; i < arr.length; i++) max = Math.max(max, dfs(arr, i));
        return max;
    }

    private int[] dp;

    private int dfs(int[][] arr, int index) {
        int max = 0;
        if (index >= arr.length) return 0;
        if (dp[index] >= 0) return dp[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i][0] > arr[index][0] && arr[i][1] > arr[index][1]) max = Math.max(max, dfs(arr, i));
        }
        return dp[index] = 1 + max;
    }
}
