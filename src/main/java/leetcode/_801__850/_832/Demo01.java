package leetcode._801__850._832;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0},
        })));
    }

    private int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length / 2; j++) {
                int tmp = image[i][j];
                image[i][j] = image[i][image.length - 1 - j] == 0 ? 1 : 0;
                image[i][image.length - 1 - j] = tmp == 0 ? 1 : 0;
            }
        }
        return image;
    }

}