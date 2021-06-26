package leetcode._901__950._909;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));
    }

    private int snakesAndLadders(int[][] board) {
        int n = board.length;
        int max = n * n;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                assert poll != null;
                if (poll == max) return ans;
                for (int i = 1; i <= 6; i++) {
                    int x = poll + i;
                    if (x > max) continue;
                    int row = n - 1 - (x - 1) / n;
                    int col = (n - 1 - row) % 2 == 0 ? (x - 1) % n : (n - 1 - (x - 1) % n);
                    if (board[row][col] != -1) x = board[row][col];
                    if (!visited.contains(x)) {
                        queue.offer(x);
                        visited.add(x);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}