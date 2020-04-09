package leetcode._56;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
                new int[]{7, 18},
        })));
    }

    private int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (isOverlay(intervals[i], intervals[j])) {
                    intervals[j] = new int[]{
                            Math.min(intervals[i][0], intervals[j][0]),
                            Math.max(intervals[i][1], intervals[j][1]),
                    };
                    intervals[i] = new int[]{0, -1};
                }
            }
        }
        List<int[]> collect = Arrays.stream(intervals).filter(s -> s[0] <= s[1]).collect(Collectors.toList());
        int[][] ints = new int[collect.size()][];
        for (int i = 0; i < collect.size(); i++) {
            ints[i] = collect.get(i);
        }
        return ints;

    }

    private boolean isOverlay(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[1])
                || (a[0] >= b[0] && a[0] <= b[1])
                || (a[1] >= b[0] && a[1] <= b[1]);
    }
}
