package leetcode._1051__1100._1094;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 5));
        System.out.println(carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));

    }

    private boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(x -> x[1]));
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(trip[2], max);
        }
        int seated = 0;
        for (int i = 0; i <= max; i++) {
            for (int[] trip : trips) {
                if (trip[2] == i) {
                    seated -= trip[0];
                }
                if (trip[1] == i) {
                    seated += trip[0];
                }
                if (seated > capacity) return false;
            }
        }
        return true;
    }

}
