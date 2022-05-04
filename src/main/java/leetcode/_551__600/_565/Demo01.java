package leetcode._551__600._565;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }


    private int arrayNesting(int[] nums) {
        int[] index = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) index[nums[i]] = i;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) ans = Math.max(ans, dfs(nums, i, index, visited));
        return ans;
    }

    private int dfs(int[] nums, int pos, int[] index, boolean[] visited) {
        if (visited[pos]) return 0;
        visited[pos] = true;
        int pre = index[pos], next = nums[pos];
        return dfs(nums, pre, index, visited) + 1 + dfs(nums, next, index, visited);
    }
}