package leetcode._801__850._806;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
    }

    private int[] numberOfLines(int[] widths, String s) {
        int cur = 0, n = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur + widths[c - 'a'] > 100) {
                n++;
                cur = widths[c - 'a'];
            } else cur += widths[c - 'a'];
        }
        return new int[]{n, cur};
    }

}