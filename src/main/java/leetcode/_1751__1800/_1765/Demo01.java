package leetcode._1751__1800._1765;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{
                {0}, {0}, {0}, {0}, {1}, {0}, {0}, {1}, {1}
        })));
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        })));
    }

    public int[][] highestPeak(int[][] isWater) {
        Arrays.stream(isWater).forEach(x -> {
            for (int i = 0; i < x.length; i++) x[i] = x[i] == 0 ? 1 : 0;
        });
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isEdge(isWater, i, j)) {
                    queue.add(new int[]{i, j});
                    visited.add(10000 * i + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i * j == 0 && i + j != 0) {
                        int a = cur[0] + i, b = cur[1] + j;
                        if (a >= 0 && b >= 0 && a < m && b < n && !visited.contains(a * 10000 + b) && isWater[a][b] != 0) {
                            isWater[a][b] = isWater[cur[0]][cur[1]] + 1;
                            queue.add(new int[]{a, b});
                            visited.add(a * 10000 + b);
                        }
                    }
                }
            }
        }
        return isWater;
    }

    private boolean isEdge(int[][] isWater, int x, int y) {
        if (isWater[x][y] == 0) return false;
        return (x - 1 >= 0 && isWater[x - 1][y] == 0) ||
                (x + 1 < isWater.length && isWater[x + 1][y] == 0) ||
                (y - 1 >= 0 && isWater[x][y - 1] == 0) ||
                (y + 1 < isWater[0].length && isWater[x][y + 1] == 0);

    }


}