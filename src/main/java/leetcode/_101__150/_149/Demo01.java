package leetcode._101__150._149;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }

    private int maxPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] a = points[i];
                int[] b = points[j];
                int gcd = Math.abs(gcd(a[1] - b[1], b[0] - a[0]));
                String key = (a[1] - b[1]) / gcd + "," + (b[0] - a[0]) / gcd + "," + (a[0] * b[1] - b[0] * a[1]) / gcd;
                if (a[0] == b[0] && a[1] == b[1]) same++;
                else map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int max = 0;
            for (Integer value : map.values()) {
                max = Math.max(max, value);
            }
            ans = Math.max(ans, max + same);
        }
        return ans + 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}