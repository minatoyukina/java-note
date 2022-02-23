package leetcode._2051__2100._2054;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}}));
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(x -> x[0]));
        int n = events.length;
        int[] suffix = new int[n];
        suffix[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) suffix[i] = Math.max(events[i][2], suffix[i + 1]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] x = events[i];
            int left = i, right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (events[mid][0] <= x[1]) left = mid + 1;
                else right = mid;
            }
            max = Math.max(max, x[2] + (events[left][0] > x[1] && left > i ? suffix[left] : 0));
        }
        return max;
    }


}
