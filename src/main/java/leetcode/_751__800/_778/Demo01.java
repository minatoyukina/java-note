package leetcode._751__800._778;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(swimInWater(new int[][]{
                {3, 2},
                {0, 1},
        }));
        System.out.println(swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        }));
    }

    private int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] min = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        min[0][0] = grid[0][0];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            Integer x = pair.getKey();
            Integer y = pair.getValue();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i * j != 0 || (i == 0 && j == 0)) continue;
                    if (x + i < 0 || y + j < 0 || x + i >= n || y + j >= n) continue;
                    if (visited[x + i][y + j]) {
                        if (min[x][y] < min[x + i][y + j]) {
                            queue.offer(new Pair<>(x + i, y + j));
                            min[x + i][y + j] = Math.max(grid[x + i][y + j], min[x][y]);
                        }
                    } else {
                        queue.offer(new Pair<>(x + i, y + j));
                        visited[x + i][y + j] = true;
                        min[x + i][y + j] = Math.max(grid[x + i][y + j], min[x][y]);
                    }
                }
            }
        }
        return min[n - 1][n - 1];
    }
}
