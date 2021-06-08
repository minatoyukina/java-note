package leetcode.lcof;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo13 {

    @Test
    public void test() {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }

    private int movingCount(int m, int n, int k) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0 && j == 0) || i * j != 0) continue;
                    int x = poll.getKey() + i, y = poll.getValue() + j;
                    if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || !check(x, y, k)) continue;
                    ans++;
                    visited[x][y] = true;
                    queue.offer(new Pair<>(x, y));
                }
            }
        }
        return ans;
    }

    private boolean check(int x, int y, int k) {
        while (x >= 10) {
            k -= x % 10;
            x /= 10;
        }
        while (y >= 10) {
            k -= y % 10;
            y /= 10;
        }
        return k - x - y >= 0;
    }
}
