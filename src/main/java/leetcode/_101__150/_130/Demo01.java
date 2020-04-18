package leetcode._101__150._130;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        char[][] chars = {
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        };
        solve(chars);
        Arrays.stream(chars).forEach(System.out::println);
    }

    private void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int x = board.length;
        int y = board[0].length;
        Set<String> list = new HashSet<>();
        for (int i = 0; i < x; i++) {
            if (board[i][0] == 'O') dfs(board, list, i, 0);
            if (board[i][y - 1] == 'O') dfs(board, list, i, y - 1);
        }
        for (int i = 1; i < y - 1; i++) {
            if (board[0][i] == 'O') dfs(board, list, 0, i);
            if (board[x - 1][i] == 'O') dfs(board, list, x - 1, i);
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (!list.contains(i + "," + j)) board[i][j] = 'X';
    }

    private void dfs(char[][] board, Set<String> list, int x, int y) {
        String s = x + "," + y;
        list.add(s);
        if (inRange(board, x - 1, y) && !list.contains((x - 1) + "," + y) && board[x - 1][y] == 'O')
            dfs(board, list, x - 1, y);
        if (inRange(board, x + 1, y) && !list.contains((x + 1) + "," + y) && board[x + 1][y] == 'O')
            dfs(board, list, x + 1, y);
        if (inRange(board, x, y - 1) && !list.contains(x + "," + (y - 1)) && board[x][y - 1] == 'O')
            dfs(board, list, x, y - 1);
        if (inRange(board, x, y + 1) && !list.contains(x + "," + (y + 1)) && board[x][y + 1] == 'O')
            dfs(board, list, x, y + 1);
    }

    private boolean inRange(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }
}
