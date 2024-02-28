package leetcode._2651__2700._2673;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
        System.out.println(minIncrements(3, new int[]{5, 3, 3}));
    }

    public int minIncrements(int n, int[] cost) {
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(null);
        List<Integer> dfs = dfs(cost, 1);
        int max = dfs.stream().max(Integer::compareTo).orElse(0);
        return dfs(cost, 1, 0, max);
    }

    private List<List<Integer>> list;

    private int dfs(int[] cost, int idx, int sum, int total) {
        if (idx - 1 >= cost.length) return 0;
        List<Integer> list = this.list.get(idx - 1);
        int max = list.stream().max(Integer::compareTo).orElse(0);
        int cur = cost[idx - 1] + total - sum - max;
        return cur - cost[idx - 1] + dfs(cost, idx * 2, sum + cur, total) + dfs(cost, idx * 2 + 1, sum + cur, total);
    }

    private List<Integer> dfs(int[] cost, int idx) {
        if (idx - 1 >= cost.length) return new ArrayList<>();
        List<Integer> left = dfs(cost, idx * 2), right = dfs(cost, idx * 2 + 1);
        List<Integer> root = new ArrayList<>();
        for (Integer integer : left) root.add(cost[idx - 1] + integer);
        for (Integer integer : right) root.add(cost[idx - 1] + integer);
        if (left.isEmpty() && right.isEmpty()) root.add(cost[idx - 1]);
        list.set(idx - 1, root);
        return root;
    }

}