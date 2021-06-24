package leetcode._201__250._216;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(200000000, 7));
    }

    private List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, new ArrayList<>(), k, n, 1, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int k, int n, int pos, int sum) {
        int size = list.size();
        if (size == k && sum == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (pos > 9 || size > k) return;
        for (int i = pos; i < 10; i++) {
            list.add(i);
            dfs(ans, list, k, n, i + 1, sum + i);
            list.remove(list.size() - 1);
        }
    }
}
