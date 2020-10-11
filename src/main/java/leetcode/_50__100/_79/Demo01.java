package leetcode._50__100._79;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        char[][] board = {
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'E', 'S'},
                new char[]{'A', 'D', 'E', 'E'},
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCESEEEFS"));
        System.out.println(exist(board, "ABCB"));
    }

    private boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, chars, i, j, 0, new boolean[board.length][board[i].length], 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int offset, boolean[][] visited, int direction) {
        if (offset == chars.length) return true;
        if (inRange(board, i, j) && !visited[i][j] && board[i][j] == chars[offset++]) {
            if (offset < chars.length
                    && (direction == 2 || (!inRange(board, i - 1, j) || board[i - 1][j] != chars[offset]))
                    && (direction == 1 || (!inRange(board, i + 1, j) || board[i + 1][j] != chars[offset]))
                    && (direction == 4 || (!inRange(board, i, j - 1) || board[i][j - 1] != chars[offset]))
                    && (direction == 3 || (!inRange(board, i, j + 1) || board[i][j + 1] != chars[offset]))
            ) {
                visited[i][j] = false;
            } else
                visited[i][j] = true;
            return dfs(board, chars, i - 1, j, offset, visited, 1)
                    || dfs(board, chars, i + 1, j, offset, visited, 2)
                    || dfs(board, chars, i, j - 1, offset, visited, 3)
                    || dfs(board, chars, i, j + 1, offset, visited, 4);
        }
        return false;
    }

    private boolean inRange(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }


}
