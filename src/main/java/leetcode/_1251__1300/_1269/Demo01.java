package leetcode._1251__1300._1269;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numWays(430, 148488));
        System.out.println(numWays(27, 7));
    }

    private int numWays(int steps, int arrLen) {
        dp = new HashMap<>();
        return dfs(steps, arrLen, 0);
    }

    private Map<Integer, Map<Integer, Integer>> dp;

    private int dfs(int steps, int arrLen, int index) {
        if (index == 0 && steps == 0) return 1;
        if (index < 0 || index >= arrLen || steps <= 0) return 0;
        if (dp.getOrDefault(steps, new HashMap<>()).containsKey(index)) return dp.get(steps).get(index);
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            sum += dfs(steps - 1, arrLen, index + i);
            int MOD = (int) 1e9 + 7;
            sum %= MOD;
        }
        Map<Integer, Integer> map = dp.getOrDefault(steps, new HashMap<>());
        map.put(index, sum);
        dp.put(steps, map);
        return sum;
    }

}