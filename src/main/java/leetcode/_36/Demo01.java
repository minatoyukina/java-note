package leetcode._36;

import org.junit.Test;

import java.util.ArrayList;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isValidSudoku(new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        }));
    }

    @SuppressWarnings("unchecked")
    private boolean isValidSudoku(char[][] board) {
        ArrayList<Character>[] list = new ArrayList[27];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>(9);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (list[i].contains(c)) {
                        return false;
                    } else {
                        list[i].add(c);
                    }
                    if (list[9 + j].contains(c)) {
                        return false;
                    } else {
                        list[9 + j].add(c);
                    }
                    if (list[18 + i / 3 * 3 + j / 3].contains(c)) {
                        return false;
                    } else {
                        list[18 + i / 3 * 3 + j / 3].add(c);
                    }
                }
            }
        }
        return true;
    }
}
