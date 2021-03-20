package leetcode._1__50._37;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        char[][] chars = {
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(chars);
        for (char[] c : chars) System.out.println(c);
    }


    private void solveSudoku(char[][] board) {
        char[][] dfs = dfs(board);
        for (int i = 0; i < 9; i++) {
            System.arraycopy(dfs[i], 0, board[i], 0, 9);
        }
    }

    private char[][] dfs(char[][] board) {
        boolean flag = true;
        for (char[] chars : board) {
            for (char c : chars) {
                if (c == '.') {
                    flag = false;
                }
            }
        }
        if (flag) return board;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] == '.') {
                    Set<Character> set = new HashSet<>();
                    for (int a = 1; a <= 9; a++) {
                        set.add((char) (a + 48));
                    }
                    for (int m = 0; m < 9; m++) {
                        set.remove(board[x][m]);
                        set.remove(board[m][y]);
                    }
                    for (int i = 0; i < 3; i++) {
                        for (int a = x / 3 * i; a < x / 3 * i + 3; a++) {
                            for (int b = y / 3 * i; b < y / 3 * i + 3; b++) {
                                set.remove(board[a][b]);
                            }
                        }
                    }
                    if (set.isEmpty()) return board;
                    for (Character character : set) {
                        char[][] clone = new char[9][9];
                        for (int i = 0; i < 9; i++) {
                            System.arraycopy(board[i], 0, clone[i], 0, 9);
                        }
                        clone[x][y] = character;
                        dfs(clone);
                    }
                }
            }
        }
        return board;
    }
}
