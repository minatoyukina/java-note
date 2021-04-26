package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0802 {

    @Test
    public void test() {

        System.out.println(pathWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
    }

    private List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) dp[i][j] = obstacleGrid[0][0] == 0;
                else {
                    if (obstacleGrid[i - 1][j - 1] == 1) dp[i][j] = false;
                    else dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        if (!dp[m][n]) return list;
        while (m >= 1 && n >= 1) {
            list.add(Arrays.asList(m - 1, n - 1));
            if (n == 1 || dp[m - 1][n]) m--;
            else n--;
        }
        Collections.reverse(list);
        return list;
    }
}
