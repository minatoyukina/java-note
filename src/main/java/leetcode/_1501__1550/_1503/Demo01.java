package leetcode._1501__1550._1503;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}));
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : right) min = Math.min(min, i);
        for (int i : left) max = Math.max(max, i);
        return Math.max(max, n - min);
    }

}