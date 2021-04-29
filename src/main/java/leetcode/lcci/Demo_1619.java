package leetcode.lcci;

import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1619 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(pondSizes(new int[][]{
                new int[]{0, 2, 1, 0},
                new int[]{0, 1, 0, 1},
                new int[]{1, 1, 0, 1},
                new int[]{0, 1, 0, 1}
        })));
    }

    private int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        int x = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) dfs(land, i, j, ++x);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] aLand : land) {
            for (int j = 0; j < n; j++) {
                if (aLand[j] < 0) {
                    map.put(aLand[j], map.getOrDefault(aLand[j], 0) + 1);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }

    private void dfs(int[][] land, int x, int y, int i) {
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] != 0) return;
        land[x][y] = -i;
        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                if (m == 0 && n == 0) continue;
                dfs(land, x + m, y + n, i);
            }
        }
    }
}
