package leetcode._1901__1950._1901;

import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findPeakGrid(Common.strToArray("[[10,20,15],[21,30,14],[7,16,32]]"))));
    }

    public int[] findPeakGrid(int[][] mat) {
        return dfs(0, 0, mat);
    }

    private int[] dfs(int x, int y, int[][] mat) {
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length) return null;
        boolean b = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i * j == 0 && i + j != 0 && isNeighborGreater(x + i, y + j, mat, mat[x][y])) {
                    b = false;
                    break;
                }
            }
        }
        if (b) return new int[]{x, y};
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i * j == 0 && i + j != 0 && isNeighborGreater(x + i, y + j, mat, mat[x][y]))
                    return dfs(x + i, y + j, mat);
            }
        }
        return null;
    }

    private boolean isNeighborGreater(int x, int y, int[][] mat, int cur) {
        return x >= 0 && y >= 0 && x < mat.length && y < mat[0].length && mat[x][y] >= cur;
    }

}