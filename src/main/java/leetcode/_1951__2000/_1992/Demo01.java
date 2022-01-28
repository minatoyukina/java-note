package leetcode._1951__2000._1992;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}})));
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    arr = new int[]{i, j, i, j};
                    dfs(i, j, land);
                    list.add(arr);
                }
            }
        }
        return list.toArray(new int[0][]);
    }

    private int[] arr;

    private void dfs(int x, int y, int[][] land) {
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] != 1) return;
        land[x][y] = -1;
        arr[0] = Math.min(arr[0], x);
        arr[1] = Math.min(arr[1], y);
        arr[2] = Math.max(arr[2], x);
        arr[3] = Math.max(arr[3], y);
        dfs(x - 1, y, land);
        dfs(x + 1, y, land);
        dfs(x, y - 1, land);
        dfs(x, y + 1, land);
    }

}