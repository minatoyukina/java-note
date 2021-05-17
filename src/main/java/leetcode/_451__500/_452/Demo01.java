package leetcode._451__500._452;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    private int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        int count = 1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int left = point[0], right = point[1];
            int x = i;
            while (x < points.length) {
                int[] ints = points[x];
                int l = ints[0], r = ints[1];
                if (l > right || r < left) {
                    count++;
                    i = x - 1;
                    break;
                } else {
                    left = Math.max(l, left);
                    right = Math.min(r, right);
                    x++;
                }
            }
        }
        return count;
    }

}
