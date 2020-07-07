package leetcode._901__950._934;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(shortestBridge(new int[][]{
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 0, 0, 0, 1},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1}

        }));
    }


    private int shortestBridge(int[][] A) {
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1 && flag) {
                    dfs(A, i, j, l1);
                    flag = false;
                    continue;
                }
                if (A[i][j] == 1 && !flag) dfs(A, i, j, l2);
            }
        int ans = A.length * A[0].length;
        for (int[] a : l1) for (int[] b : l2) ans = Math.min(ans, Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]));
        return ans - 1;
    }

    private void dfs(int[][] a, int i, int j, List<int[]> list) {
        if (i >= 0 && i < a.length && j >= 0 && j < a.length && a[i][j] == 1) {
            list.add(new int[]{i, j});
            a[i][j] = -1;
            dfs(a, i - 1, j, list);
            dfs(a, i + 1, j, list);
            dfs(a, i, j + 1, list);
            dfs(a, i, j - 1, list);
        }
    }

}
