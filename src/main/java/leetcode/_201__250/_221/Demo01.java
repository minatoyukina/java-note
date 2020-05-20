package leetcode._201__250._221;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(maximalSquare(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        }));
    }

    private int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int length = 1;
                    boolean f1 = true, f2 = true;
                    while (i + length < m && j + length < n) {
                        for (int y = j; y <= j + length; y++) {
                            if (matrix[i + length][y] != '1') {
                                f1 = false;
                                break;
                            }
                        }
                        for (int x = i; x <= i + length; x++) {
                            if (matrix[x][j + length] != '1') {
                                f2 = false;
                                break;
                            }
                        }
                        if (f1 && f2) length++;
                        else break;
                    }
                    ans = Math.max(ans, length * length);
                }
            }
        }
        return ans;
    }

}
