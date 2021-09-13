package leetcode._401__450._447;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}}));
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        Map<Long, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = points[j][0] - points[i][0], b = points[j][1] - points[i][1];
                long k1 = hash(points[i][0], points[i][1]), k2 = hash(points[j][0], points[j][1]);
                int x = a * a + b * b;
                Map<Integer, Integer> m1 = map.computeIfAbsent(k1, k -> new HashMap<>());
                m1.put(x, m1.getOrDefault(x, 0) + 1);
                Map<Integer, Integer> m2 = map.computeIfAbsent(k2, k -> new HashMap<>());
                m2.put(x, m2.getOrDefault(x, 0) + 1);
            }
        }
        return map.values().stream().flatMap(s -> s.values().stream()).map(s -> s * (s - 1)).reduce(Integer::sum).orElse(0);
    }

    private long hash(int a, int b) {
        int x = a >= 0 ? (b >= 0 ? 4 : 3) : (b >= 0 ? 2 : 1);
        return Math.abs(a) * (long) 1e6 + Math.abs(b) * 10L + x;
    }

}