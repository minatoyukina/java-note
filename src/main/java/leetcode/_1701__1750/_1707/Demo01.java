package leetcode._1701__1750._1707;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(
                maximizeXor(new int[]{0, 1, 2, 3, 4},
                        new int[][]{{3, 1}, {1, 3}, {5, 6}})));
    }

    private int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num <= queries[i][1]) {
                    max = Math.max(max, queries[i][0] ^ num);
                } else break;
            }
            if (max == Integer.MIN_VALUE) ans[i] = -1;
            else ans[i] = max;
        }
        return ans;
    }

}