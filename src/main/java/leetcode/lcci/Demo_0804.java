package leetcode.lcci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0804 {

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0);
    }

    private List<List<Integer>> dfs(int[] nums, int pos) {
        List<List<Integer>> list = new ArrayList<>();
        if (pos >= nums.length) {
            list.add(new ArrayList<>());
            return list;
        }
        List<List<Integer>> dfs = dfs(nums, pos + 1);
        list.addAll(dfs);
        for (List<Integer> df : dfs) {
            ArrayList<Integer> copy = new ArrayList<>(df);
            copy.add(nums[pos]);
            list.add(copy);
        }
        return list;
    }
}
