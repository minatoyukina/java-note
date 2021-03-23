package leetcode._1__50._37;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        char[][] chars = {
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
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
                    for (int a = x / 3 * 3; a < x / 3 * 3 + 3; a++) {
                        for (int b = y / 3 * 3; b < y / 3 * 3 + 3; b++) {
                            set.remove(board[a][b]);
                        }
                    }
                    if (set.isEmpty()) return board;
                    label:
                    for (Character character : set) {
                        char[][] clone = new char[9][9];
                        for (int i = 0; i < 9; i++) {
                            System.arraycopy(board[i], 0, clone[i], 0, 9);
                        }
                        clone[x][y] = character;
                        char[][] dfs = dfs(clone);
                        for (char[] chars : dfs) {
                            for (char c : chars) {
                                if (c == '.') continue label;
                            }
                        }
                        return dfs;
                    }
                    return board;
                }
            }
        }
        return board;
    }
}
