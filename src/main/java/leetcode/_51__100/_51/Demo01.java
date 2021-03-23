package leetcode._51__100._51;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(1));
    }

    private List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] cols = new int[n];
        Arrays.fill(cols, -1);
        dfs(n, -1, cols, list);
        return list;
    }

    private void dfs(int n, int x, int[] cols, List<List<String>> list) {
        x++;
        if (cols[n - 1] != -1) {
            List<String> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == cols[i]) sb.append("Q");
                    else sb.append(".");
                }
                sub.add(sb.toString());
            }
            list.add(sub);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(n, x, i, cols)) {
                cols[x] = i;
                dfs(n, x, Arrays.copyOf(cols, cols.length), list);
            }
        }
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
