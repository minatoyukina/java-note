package leetcode._51__100._52;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(1));
    }

    private int totalNQueens(int n) {
        int[] cols = new int[n];
        Arrays.fill(cols, -1);
        return dfs(n, -1, cols);
    }

    private int dfs(int n, int x, int[] cols) {
        x++;
        int ans = 0;
        if (cols[n - 1] != -1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(n, x, i, cols)) {
                cols[x] = i;
                ans += dfs(n, x, Arrays.copyOf(cols, cols.length));
            }
        }
        return ans;
    }

    @SuppressWarnings("all")
    private boolean isValid(int n, int x, int y, int[] cols) {
        for (int i = 0; i < n; i++) {
            if (cols[i] == -1) break;
            int a = i - x;
            int b = cols[i] - y;
            if (Math.abs(a) == Math.abs(b) || y == cols[i]) return false;
        }
        return true;
    }
}
