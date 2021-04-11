package leetcode._201__250._210;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findOrder(7, new int[][]{
                {1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}})));
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1, 0}})));
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : prerequisites) {
            List<Integer> list = map.getOrDefault(ints[0], new ArrayList<>());
            list.add(ints[1]);
            map.put(ints[0], list);
        }
        Set<Integer> dfs = dfs(numCourses, 0, map, new HashSet<>(), new HashSet<>());
        if (dfs.size() == 0) return new int[0];
        ArrayList<Integer> list = new ArrayList<>(dfs);
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private Set<Integer> dfs(int num, int index, Map<Integer, List<Integer>> map, Set<Integer> set, Set<Integer> memo) {
        if (index >= num) {
            if (set.size() == num) return set;
            return dfs(num, 0, map, set, new HashSet<>());
        }
        List<Integer> list = map.get(index);
        if (list == null || set.containsAll(list)) {
            Set<Integer> copy = new LinkedHashSet<>(set);
            copy.add(index);
            return dfs(num, index + 1, map, copy, new HashSet<>());
        } else {
            for (Integer integer : list) {
                if (!set.contains(integer) && !memo.contains(integer)) {
                    memo.add(integer);
                    Set<Integer> dfs = dfs(num, integer, map, set, memo);
                    if (dfs.size() == num) return dfs;
                }
            }
        }
        return new HashSet<>();
    }
}
