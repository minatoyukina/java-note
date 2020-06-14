package leetcode._1162;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxDistance(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
                new int[]{1, 0, 1},
        }));
    }

    private int maxDistance(int[][] grid) {
        List<Pair<Integer, Integer>> land = new ArrayList<>();
        List<Pair<Integer, Integer>> ocean = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) land.add(new Pair<>(i, j));
                else ocean.add(new Pair<>(i, j));
            }
        }
        if (land.size() == grid.length * grid[0].length || land.size() == 0) return -1;
        List<Integer> list = new ArrayList<>();
        for (Pair<Integer, Integer> x : ocean) {
            int d = Integer.MAX_VALUE;
            int m = -1, n = -1;
            for (Pair<Integer, Integer> y : land) {
                if (m == -1) {
                    m = y.getKey();
                    n = y.getValue();
                } else {
                    if (m + n > y.getKey() + y.getValue()) continue;
                }
                int t = Math.abs(x.getKey() - y.getKey()) + Math.abs(x.getValue() - y.getValue());
                d = Math.min(d, t);
                if (y.getKey() - x.getKey() >= d || y.getValue() - x.getValue() >= d || d == 1) break;
            }
            list.add(d);
        }
        return Collections.max(list);
    }
}
