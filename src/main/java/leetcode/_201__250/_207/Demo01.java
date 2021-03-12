package leetcode._201__250._207;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canFinish(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            Set<Integer> set = map.getOrDefault(key, new HashSet<>());
            set.add(prerequisite[1]);
            map.put(key, set);
        }
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, new HashSet<>(), dp)) return false;
        }
        return true;
    }

    @SuppressWarnings("all")
    private boolean dfs(int i, Map<Integer, Set<Integer>> map, Set<Integer> memo, boolean[] dp) {
        Set<Integer> set = map.get(i);
        if (set == null || set.isEmpty() || dp[i]) {
            dp[i] = true;
            return true;
        }
        if (memo.contains(i)) return false;
        memo.add(i);
        for (int s : set) {
            if (!dfs(s, map, new HashSet<>(memo), dp)) {
                return false;
            }
        }
        dp[i] = true;
        return true;
    }

}