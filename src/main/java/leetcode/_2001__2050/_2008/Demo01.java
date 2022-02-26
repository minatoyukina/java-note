package leetcode._2001__2050._2008;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maxTaxiEarnings(20, Common.strToArray("[[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]")));
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> map = Arrays.stream(rides).collect(Collectors.groupingBy(x -> x[1]));
        for (int i = 1; i <= n; i++) {
            List<int[]> list = map.getOrDefault(i, Collections.emptyList());
            dp[i] = dp[i - 1];
            for (int[] arr : list) {
                int start = arr[0], end = arr[1], tip = arr[2];
                dp[i] = Math.max(dp[i], dp[start] + end - start + tip);
            }
        }
        return dp[n];
    }

}
