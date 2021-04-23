package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0401 {

    @Test
    public void test() {
        System.out.println(findWhetherExistsPath(3, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{1, 2},
        }, 0, 2));
        System.out.println(findWhetherExistsPath(4, new int[][]{
                new int[]{1, 2},
                new int[]{1, 1},
        }, 1, 1));
    }

    private int[] dp;


    private boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        dp = new int[n];
        if (start > n || target > n) return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : graph) {
            List<Integer> list = map.getOrDefault(ints[0], new ArrayList<>());
            list.add(ints[1]);
            map.put(ints[0], list);
        }
        return dfs(map, start, target);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int start, int target) {
        if (dp[start] != 0) return dp[start] > 0;
        if (start == target) {
            dp[start] = 1;
            return true;
        }
        List<Integer> list = map.get(start);
        if (list == null) {
            dp[start] = -1;
            return false;
        }
        for (Integer integer : list) {
            if (dfs(map, integer, target)) {
                dp[integer] = 1;
                return true;
            }
        }
        dp[start] = -1;
        return false;
    }

}
