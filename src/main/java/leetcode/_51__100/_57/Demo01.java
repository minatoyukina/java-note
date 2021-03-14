package leetcode._51__100._57;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(insert(new int[][]{
                new int[]{1, 3},
                new int[]{6, 9},
        }, new int[]{2, 5})));
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0, right = intervals.length - 1;
        int m = newInterval[0];
        int n = newInterval[1];
        double f = 3.1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int y = intervals[mid][0];
            if (m > y) left = mid;
            else if (m < y) right = mid;
            else break;
        }
        int[] l = intervals[left];
        int[] r = intervals[right];
        if (n > l[1]) {
        }
        return null;
    }
}
