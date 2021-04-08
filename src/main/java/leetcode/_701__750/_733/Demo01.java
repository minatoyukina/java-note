package leetcode._701__750._733;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(floodFill(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}}, 2, 2, 3)));
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc]);
        for (int[] ints : image) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] < 0) ints[i] = newColor;
            }
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length) {
            if (image[sr][sc] == color) image[sr][sc] = -1;
            else return;
        } else return;
        dfs(image, sr - 1, sc, color);
        dfs(image, sr + 1, sc, color);
        dfs(image, sr, sc + 1, color);
        dfs(image, sr, sc - 1, color);
    }

}