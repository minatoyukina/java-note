package leetcode._1__50._7;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(reverse(0));
        System.out.println(reverse(-12300));
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    private int reverse(int x) {
        while (x % 10 == 0 && x != 0) {
            x = x / 10;
        }
        String a = x + "";
        String b;
        if (a.startsWith("-")) {
            b = "-" + new StringBuilder(a.substring(1)).reverse().toString();
        } else {
            b = new StringBuilder(a).reverse().toString();
        }
        long l = Long.parseLong(b);
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) l;
    }
}
