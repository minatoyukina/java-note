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
        int[] dp = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (ng(i, map, new HashSet<>(), dp)) return false;
        }
        return true;
    }

    private boolean ng(int i, Map<Integer, Set<Integer>> map, Set<Integer> memo, int[] dp) {
        if (dp[i] == -1) return true;
        Set<Integer> set = map.get(i);
        if (set == null || set.isEmpty() || dp[i] == 1) {
            dp[i] = 1;
            return false;
        }
        if (memo.contains(i)) {
            dp[i] = -1;
            return true;
        }
        memo.add(i);
        for (int s : set) {
            if (ng(s, map, new HashSet<>(memo), dp)) {
                return true;
            }
        }
        dp[i] = 1;
        return false;
    }

}