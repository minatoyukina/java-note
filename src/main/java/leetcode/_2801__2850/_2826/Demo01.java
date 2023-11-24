package leetcode._2801__2850._2826;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumOperations(Arrays.asList(1, 2)));
        System.out.println(minimumOperations(Arrays.asList(2, 1, 3, 2, 1)));
    }

    public int minimumOperations(List<Integer> nums) {
        return dfs(nums, 0, 1);
    }

    private int dfs(List<Integer> nums, int pos, int pre) {
        if (pos >= nums.size()) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = pre; i <= 3; i++) min = Math.min(min, dfs(nums, pos + 1, i) + (nums.get(pos) == i ? 0 : 1));
        return min;
    }

}