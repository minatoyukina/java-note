package leetcode._455;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    private int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, index = -1;
        for (int value : s) {
            for (int j = index + 1; j < g.length; j++) {
                if (value >= g[j]) {
                    count++;
                    index = j;
                    break;
                }
            }
        }
        return count;
    }


}
