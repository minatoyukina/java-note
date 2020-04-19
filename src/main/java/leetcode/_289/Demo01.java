package leetcode._289;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        int[][] board = {
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0},
        };
        gameOfLife(board);
        Arrays.stream(board).forEach(s -> System.out.println(Arrays.toString(s)));
    }


    private void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (x == 0 && y == 0) continue;
                        if (inRange(i + x, j + y, board)) {
                            int point = board[i + x][j + y];
                            if (point == 1 || point == 3) live++;
                        }
                    }
                }
                if (board[i][j] == 0) {
                    if (live == 3) board[i][j] = 2; //死变活
                } else {
                    if (live < 2 || live > 3) board[i][j] = 3; //活变死
                }
            }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                if (board[i][j] == 3) board[i][j] = 0;
            }
        }
    }

    private boolean inRange(int i, int j, int[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length;
    }
}
