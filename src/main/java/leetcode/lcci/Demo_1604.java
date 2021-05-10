package leetcode.lcci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1604 {

    @Test
    public void test() {
        System.out.println(tictactoe(new String[]{"O X", " XO", "X O"}));
    }

    private String tictactoe(String[] board) {
        int n = board.length;
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String s = board[i];
            String[] split = s.split("");
            System.arraycopy(split, 0, matrix[i], 0, split.length);
        }
        for (int i = 0; i < n; i++) {
            String a = matrix[i][0];
            String b = matrix[0][i];
            for (int j = 0; j < n; j++) {
                if (!matrix[i][j].equals(a) || a.equals(" ")) break;
                if (j == n - 1) return a;
            }
            for (int j = 0; j < n; j++) {
                if (!matrix[j][i].equals(b) || b.equals(" ")) break;
                if (j == n - 1) return b;
            }
        }
        String c = matrix[0][0];
        String d = matrix[n - 1][0];
        for (int a = 0, b = 0; a < n && b < n; a++, b++) {
            if (!matrix[a][b].equals(c) || c.equals(" ")) break;
            if (a == n - 1 && b == n - 1) return c;
        }
        for (int a = n - 1, b = 0; a < n && b < n; a--, b++) {
            if (!matrix[a][b].equals(d) || d.equals(" ")) break;
            if (a == 0 && b == n - 1) return d;
        }
        return Arrays.stream(board).noneMatch(s -> s.contains(" ")) ? "Draw" : "Pending";
    }
}
