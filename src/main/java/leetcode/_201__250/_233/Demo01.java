package leetcode._201__250._233;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countDigitOne(20));
        System.out.println(countDigitOne(13));
    }

    private int countDigitOne(int n) {
        int num = n, i = 1, s = 0;
        while (num > 0) {
            if (num % 10 == 0) s += (num / 10) * i;
            if (num % 10 == 1) s += (num / 10) * i + (n % i) + 1;
            if (num % 10 > 1) s += (int) Math.ceil(num / 10.0) * i;
            num /= 10;
            i *= 10;
        }
        return s;
    }

}