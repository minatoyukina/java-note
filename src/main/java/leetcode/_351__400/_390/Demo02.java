package leetcode._351__400._390;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "=>" + lastRemaining(i));
        }
    }

    private int lastRemaining(int n) {
        int start = 1, step = 1;
        boolean l2r = true;
        while (n > 1) {
            if (l2r || n % 2 == 1) start += step;
            n /= 2;
            l2r = !l2r;
            step *= 2;
        }
        return start;
    }

}