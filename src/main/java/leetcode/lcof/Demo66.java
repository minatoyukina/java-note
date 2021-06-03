package leetcode.lcof;

import org.junit.Test;

import java.util.Arrays;

public class Demo66 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
    }

    private int[] constructArr(int[] a) {
        int ans[] = new int[a.length];
        if (a.length <= 1) return ans;
        int[] left = new int[a.length + 1];
        int[] right = new int[a.length + 1];
        left[0] = 1;
        right[0] = 1;
        for (int i = 0; i < a.length; i++) {
            left[i + 1] = left[i] * a[i];
            right[i + 1] = right[i] * a[a.length - 1 - i];
        }
        for (int i = 0; i < a.length; i++) {
            ans[i] = left[i] * right[a.length - 1 - i];
        }
        return ans;
    }
}
