package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0813 {

    @Test
    public void test() {
        System.out.println(pileBox(new int[][]{
                new int[]{1, 1, 1},
                new int[]{2, 3, 4},
                new int[]{2, 6, 7},
                new int[]{3, 4, 5},
        }));
    }

    private int[] dp;

    private int pileBox(int[][] box) {
        dp = new int[box.length];
        int ans = 0;
        for (int i = 0; i < box.length; i++) ans = Math.max(ans, dfs(box, i));
        return ans;
    }

    private int dfs(int[][] box, int index) {
        if (dp[index] > 0) return dp[index];
        int max = 0;
        for (int i = 0; i < box.length; i++) {
            int[] ints = box[i];
            if (box[index][0] > ints[0] && box[index][1] > ints[1] && box[index][2] > ints[2])
                max = Math.max(max, dfs(box, i));
        }
        return dp[index] = box[index][2] + max;
    }
}
