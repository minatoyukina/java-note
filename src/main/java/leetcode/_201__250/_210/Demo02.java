package leetcode._201__250._210;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo02 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1, 0}, {0, 1}, {1, 2}})));
        System.out.println(Arrays.toString(findOrder(7, new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}})));
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1, 0}})));
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        valid = true;
        index = numCourses - 1;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) edges.add(new ArrayList<>());
        int[] visited = new int[numCourses];
        int[] ans = new int[numCourses];
        for (int[] ints : prerequisites) edges.get(ints[1]).add(ints[0]);
        for (int i = 0; i < numCourses; i++) if (visited[i] == 0) dfs(edges, ans, i, visited);
        if (!valid) return new int[0];
        return ans;
    }

    private boolean valid;
    private int index;

    private void dfs(List<List<Integer>> edges, int[] ans, int pos, int[] visited) {
        visited[pos] = 1;
        List<Integer> list = edges.get(pos);
        for (Integer i : list) {
            if (visited[i] == 1) {
                valid = false;
                return;
            }
            if (visited[i] == 0) {
                dfs(edges, ans, i, visited);
                if (!valid) return;
            }
        }
        visited[pos] = 2;
        ans[index--] = pos;
    }
}
