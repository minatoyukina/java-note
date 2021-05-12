package leetcode._1301__1350._1310;

import org.junit.Test;

import java.util.Arrays;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
    }

    private int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) pre[i + 1] = pre[i] ^ arr[i];
        for (int i = 0; i < queries.length; i++) ans[i] = pre[queries[i][1] + 1] ^ pre[queries[i][0]];
        return ans;
    }

}