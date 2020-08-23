package leetcode._501__550._529;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        Arrays.stream(updateBoard(new char[][]{
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'M', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'}
        }, new int[]{3, 0})).forEach(s -> System.out.println(Arrays.toString(s)));
        Arrays.stream(updateBoard(new char[][]{
                new char[]{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
                new char[]{'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'},
                new char[]{'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'}
        }, new int[]{0, 0})).forEach(s -> System.out.println(Arrays.toString(s)));
    }

    private char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        boolean[][] visited = new boolean[m][n];
        dfs(board, visited, x, y);
        return board;
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y) {
        if (inRange(board, x, y) && !visited[x][y]) {
            visited[x][y] = true;
            int mine = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (inRange(board, x + i, y + j)) {
                        if (board[x + i][y + j] == 'M') mine++;
                    }
                }
            }
            if (mine > 0) board[x][y] = Integer.toString(mine).charAt(0);
            else {
                board[x][y] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        dfs(board, visited, x + i, y + j);
                    }
                }
            }
        }
    }

    private boolean inRange(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

}
