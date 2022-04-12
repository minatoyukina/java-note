package leetcode._1901__1950._1926;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(nearestExit(new char[][]{
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        }, new int[]{1, 0}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int N = 1000, m = maze.length, n = maze[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(entrance[0] * N + entrance[1]);
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                assert poll != null;
                int x = poll / N, y = poll - x * N;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int a = x + i, b = y + j;
                        if (i * j == 0 && a >= 0 && b >= 0 && a < m && b < n && maze[a][b] == '.') {
                            if (a == 0 || b == 0 || a == m - 1 || b == n - 1) return step + 1;
                            queue.add(N * a + b);
                            maze[a][b] = '+';
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

}