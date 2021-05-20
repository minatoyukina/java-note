package leetcode._51__100._57;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(insert(new int[][]{new int[]{1, 5}}, new int[]{2, 3})));
        System.out.println(Arrays.deepToString(insert(new int[][]{
                new int[]{1, 3},
                new int[]{6, 9},
        }, new int[]{2, 5})));
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0, right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (newInterval[0] > intervals[mid][1]) {
                left = mid + 1;
            } else if (newInterval[1] < intervals[mid][0]) {
                right = mid - 1;
            } else {
                int x = mid, y = mid;
                while (x >= 0 && over(newInterval, intervals[x])) x--;
                while (y < intervals.length && over(newInterval, intervals[y])) y++;
                int[][] ans = new int[intervals.length - ((y - 1) - (x + 1) + 1) + 1][2];
                int z = 0;
                boolean flag = true;
                for (int i = 0; i < intervals.length; i++) {
                    if (i >= x + 1 && i <= y - 1) {
                        if (flag)
                            ans[z++] = new int[]{
                                    Math.min(newInterval[0], intervals[x + 1][0]),
                                    Math.max(newInterval[1], intervals[y - 1][1])};
                        flag = false;
                    } else ans[z++] = intervals[i];
                }
                return ans;
            }
        }
        return Stream.of(intervals, new int[][]{newInterval}).flatMap(Arrays::stream).sorted(Comparator.comparingInt(x -> x[0])).toArray(int[][]::new);
    }

    private boolean over(int[] newInterval, int[] interval) {
        return !(newInterval[1] < interval[0] || newInterval[0] > interval[1]);
    }
}
