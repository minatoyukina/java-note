package leetcode._401__450._419;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countBattleships(new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
        }));
    }

    private int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    res++;
                    board[i][j] = 'O';
                    for (int x = i + 1; x < board.length; x++) {
                        if (board[x][j] == 'X') board[x][j] = 'O';
                        else break;
                    }
                    for (int x = j + 1; x < board[i].length; x++) {
                        if (board[i][x] == 'X') board[i][x] = 'O';
                        else break;
                    }
                }
            }
        }
        return res;
    }

}