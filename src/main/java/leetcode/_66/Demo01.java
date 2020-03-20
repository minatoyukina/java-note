package leetcode._66;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    private int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] s = new int[length + 1];
                    s[0] = 1;
                    return s;
                }
                continue;
            }
            digits[i]++;
            break;
        }
        return digits;
    }
}
