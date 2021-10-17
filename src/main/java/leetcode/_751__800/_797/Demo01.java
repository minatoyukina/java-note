package leetcode._751__800._797;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, ans, Collections.singletonList(0), 0);
        return ans;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> list, int pos) {
        int[] ints = graph[pos];
        if (pos == graph.length - 1) {
            ans.add(list);
            return;
        }
        for (int i : ints) {
            ArrayList<Integer> copy = new ArrayList<>(list);
            copy.add(i);
            dfs(graph, ans, copy, i);
        }
    }

}