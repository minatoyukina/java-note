package leetcode._1951__2000._1996;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numberOfWeakCharacters(new int[][]{{2, 2}, {1, 1}, {1, 2}, {2, 1}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        int maxDef = 0, count = 0;
        for (int[] property : properties) {
            if (property[1] < maxDef) count++;
            else maxDef = property[1];
        }
        return count;
    }

}