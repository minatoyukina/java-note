package leetcode._201__250._210;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1, 0}, {0, 1}, {1, 2}})));
        System.out.println(Arrays.toString(findOrder(7, new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}})));
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
        List<Integer> list = new ArrayList<>();
        dfs(numCourses, map, list, new boolean[numCourses]);
        if (list.size() != numCourses) return new int[0];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }

    private void dfs(int num, Map<Integer, List<Integer>> map, List<Integer> list, boolean[] visited) {
        for (int i = 0; i < num; i++) {
            List<Integer> v = map.getOrDefault(i, new ArrayList<>());
            if (check(visited, v) && !visited[i]) {
                list.add(i);
                visited[i] = true;
                dfs(num, map, list, visited);
                if (list.size() == num) return;
            }
        }
    }

    private boolean check(boolean[] visited, List<Integer> list) {
        for (Integer integer : list) if (!visited[integer]) return false;
        return true;
    }
}
