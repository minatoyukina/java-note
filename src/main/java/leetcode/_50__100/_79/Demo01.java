package leetcode._50__100._79;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        char[][] board = {
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
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
                if (dfs(board, chars, i, j, 0, new boolean[board.length][board[i].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int offset, boolean[][] visited) {
        if (offset == chars.length) return true;
        if (inRange(board, i, j) && !visited[i][j] && board[i][j] == chars[offset++]) {
            visited[i][j] = true;
            boolean b = dfs(board, chars, i - 1, j, offset, visited)
                    || dfs(board, chars, i + 1, j, offset, visited)
                    || dfs(board, chars, i, j - 1, offset, visited)
                    || dfs(board, chars, i, j + 1, offset, visited);
            visited[i][j] = false;
            return b;
        }
        return false;
    }

    private boolean inRange(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }


}
