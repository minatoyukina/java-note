package leetcode._2201__2250._2218;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maxValueOfCoins(Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9)), 2));
        System.out.println(maxValueOfCoins(Arrays.asList(Collections.singletonList(100), Collections.singletonList(100), Collections.singletonList(100),
                Collections.singletonList(100), Collections.singletonList(100), Collections.singletonList(100), Arrays.asList(1, 1, 1, 1, 1, 1, 700)), 7));
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[k + 1][piles.size()];
        for (List<Integer> pile : piles)
            for (int i = 1; i < pile.size(); i++) pile.set(i, pile.get(i - 1) + pile.get(i));
        return dfs(piles, k, 0);
    }

    private int[][] dp;

    private int dfs(List<List<Integer>> piles, int k, int index) {
        if (index >= piles.size() || k <= 0) return 0;
        if (dp[k][index] != 0) return dp[k][index];
        int max = dfs(piles, k, index + 1);
        List<Integer> list = piles.get(index);
        for (int i = 0; i < Math.min(k, list.size()); i++)
            max = Math.max(max, list.get(i) + dfs(piles, k - i - 1, index + 1));
        return dp[k][index] = max;
    }
}
