package leetcode._751__800._773;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }

    private int slidingPuzzle(int[][] board) {
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        Set<String> set = new HashSet<>();
        set.add(Arrays.deepToString(board));
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[][] poll = queue.poll();
                assert poll != null;
                if (Arrays.deepEquals(poll, new int[][]{{1, 2, 3}, {4, 5, 0}})) return ans;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (poll[i][j] == 0) {
                            helper(poll, i, j, i - 1, j, queue, set);
                            helper(poll, i, j, i + 1, j, queue, set);
                            helper(poll, i, j, i, j - 1, queue, set);
                            helper(poll, i, j, i, j + 1, queue, set);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private void helper(int[][] board, int x, int y, int m, int n, Queue<int[][]> queue, Set<String> set) {
        int[][] copy = new int[2][3];
        for (int i = 0; i < 2; i++) System.arraycopy(board[i], 0, copy[i], 0, 3);
        if (m >= 0 && m < 2 && n >= 0 && n < 3) {
            int tmp = copy[x][y];
            copy[x][y] = copy[m][n];
            copy[m][n] = tmp;
            String s = Arrays.deepToString(copy);
            if (!set.contains(s)) {
                queue.offer(copy);
                set.add(s);
            }
        }
    }
}