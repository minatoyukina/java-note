package leetcode._1001__1050._1024;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(videoStitching(new int[][]{
                {0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}
        }, 10));
        System.out.println(videoStitching(new int[][]{
                {0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}

        }, 9));
        System.out.println(videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
        System.out.println(videoStitching(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 4));
        System.out.println(videoStitching(new int[][]{{2, 4}}, 1));
    }

    private int videoStitching(int[][] clips, int T) {
        if (T == 0) return 0;
        return dfs(clips, 0, T, new HashSet<>(), 0);
    }

    private int dfs(int[][] clips, int left, int right, Set<Integer> set, int count) {
        int i = left, j = right;
        int a = -1, b = -1;
        for (int x = 0; x < clips.length; x++) {
            if (set.contains(x)) continue;
            int[] clip = clips[x];
            if (clip[0] <= left) {
                if (clip[1] > i) {
                    i = clip[1];
                    a = x;
                }
            }
            if (clip[1] >= right) {
                if (clip[0] < j) {
                    j = clip[0];
                    b = x;
                }
            }
        }
        if (a == -1 && b == -1) return -1;
        if (a >= 0 && b >= 0) {
            if (clips[a][1] >= right || clips[b][0] <= left) return count + 1;
            if (clips[a][1] >= clips[b][0]) return count + 2;
        }
        set.add(a);
        set.add(b);
        return dfs(clips, i, j, set, count + 2);
    }
}
