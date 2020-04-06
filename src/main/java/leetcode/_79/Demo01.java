package leetcode._79;

import org.junit.Test;

import java.util.List;
import java.util.Map;

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
    }

    private boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (i == 0 || j == 0) {

                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, List<Map<Integer, Integer>> list) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (i == 0 || j == 0) {

                    }
                }
            }
        }
        return false;
    }


}
