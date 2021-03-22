package leetcode._951__1000._999;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numRookCaptures(new char[][]{
                {'R'}
        }));
    }

    private int numRookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    for (int a = i - 1; a >= 0; a--) {
                        if (board[a][j] != '.' && board[a][j] != 'p') break;
                        if (board[a][j] == 'p') {
                            res++;
                            break;
                        }
                    }
                    for (int a = j - 1; a >= 0; a--) {
                        if (board[i][a] != '.' && board[i][a] != 'p') break;
                        if (board[i][a] == 'p') {
                            res++;
                            break;
                        }
                    }
                    for (int a = i + 1; a < board.length; a++) {
                        if (board[a][j] != '.' && board[a][j] != 'p') break;
                        if (board[a][j] == 'p') {
                            res++;
                            break;
                        }
                    }
                    for (int a = j + 1; a < board[i].length; a++) {
                        if (board[i][a] != '.' && board[i][a] != 'p') break;
                        if (board[i][a] == 'p') {
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

}