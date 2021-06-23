package leetcode._901__950._939;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
    }

    private int minAreaRect(int[][] points) {
        Arrays.sort(points, (x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int a = Math.abs(points[i][0] - points[j][0]);
                int b = Math.abs(points[i][1] - points[j][1]);
                if (a * b != 0) min = Math.min(min, a * b);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}