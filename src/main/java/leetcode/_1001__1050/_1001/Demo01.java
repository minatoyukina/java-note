package leetcode._1001__1050._1001;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(gridIllumination(1, new int[][]{{0, 0}, {0, 0}}, new int[][]{{0, 0}, {0, 0}})));
        System.out.println(Arrays.toString(gridIllumination(5, new int[][]{{0, 0}, {0, 4}}, new int[][]{{0, 4}, {0, 1}, {1, 4}})));
    }

    @SuppressWarnings("all")
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> h = new HashMap<>();
        Map<Integer, Integer> v = new HashMap<>();
        Map<Integer, Integer> s = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();
        Set<Integer> lighted = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            if (lighted.contains(100_000 * x + y)) continue;
            h.merge(x, 1, Integer::sum);
            v.merge(y, 1, Integer::sum);
            s.merge(x + y, 1, Integer::sum);
            b.merge(n + x - y - 1, 1, Integer::sum);
            lighted.add(x * 100_000 + y);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0], y = query[1];
            if (h.getOrDefault(x, 0) > 0 ||
                    v.getOrDefault(y, 0) > 0 ||
                    s.getOrDefault(x + y, 0) > 0 ||
                    b.getOrDefault(n + x - y - 1, 0) > 0) ans[i]++;
            for (int p = -1; p <= 1; p++) {
                for (int q = -1; q <= 1; q++) {
                    int k = x + p, l = y + q;
                    if (!lighted.remove(100_000 * k + l)) continue;
                    h.compute(k, (v1, v2) -> v2 - 1);
                    v.compute(l, (v1, v2) -> v2 - 1);
                    s.compute(k + l, (v1, v2) -> v2 - 1);
                    b.compute(n + k - l - 1, (v1, v2) -> v2 - 1);
                }
            }

        }
        return ans;
    }

}