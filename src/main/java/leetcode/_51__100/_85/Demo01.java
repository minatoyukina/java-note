package leetcode._51__100._85;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(maximalRectangle(new char[][]{
                {'0', '0', '0', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '0', '0', '0'},
                {'0', '1', '0', '1', '0', '0', '1'},
                {'0', '0', '1', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '0', '1', '0', '1', '1'},
                {'0', '1', '0', '0', '1', '0', '1'},
                {'1', '1', '0', '1', '1', '1', '0'},
                {'1', '0', '1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '0', '0', '0'}


        }));

    }

    private int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int width = 1;
                    int height = 1;
                    for (int x = j + 1; x < n; x++) {
                        if (matrix[i][x] == '0') break;
                        width++;
                    }
                    ans = Math.max(ans, width * height);
                    for (int x = i + 1; x < m; x++) {
                        int count = 0;
                        for (int y = j; y < j + width; y++) {
                            if (matrix[x][y] == '0') break;
                            count++;
                        }
                        if (count == 0) break;
                        height++;
                        if (count < width) {
                            width = count;
                            ans = Math.max(ans, count * height);
                        } else ans = Math.max(ans, width * height);
                    }
                }
            }
        }
        return ans;
    }
}
