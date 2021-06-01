package leetcode._1701__1750._1744;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000}})));
        System.out.println(Arrays.toString(canEat(new int[]{8, 4, 5, 3, 8}, new int[][]{{0, 7, 4}})));
    }

    private boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] pre = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) {
            pre[i + 1] = pre[i] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (check(pre, query[0], query[1], query[2])) ans[i] = true;
        }
        return ans;
    }

    private boolean check(long[] pre, int type, int day, int max) {
//        return pre[type] <= (long) day * max && day < pre[type + 1];
        return pre[type] < (long) (day + 1) * max && day < pre[type + 1];
    }

}

