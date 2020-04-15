package leetcode._274;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(hIndex(new int[]{4, 2, 3, 1, 5}));
        System.out.println(hIndex(new int[]{0}));
    }

    private int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[citations.length - 1 - i] < i + 1) return i;
            else if (i == citations.length - 1) return citations.length;
        }
        return 0;
    }
}
