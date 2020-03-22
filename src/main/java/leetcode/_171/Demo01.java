package leetcode._171;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("J"));
        System.out.println(Math.log(4));
        System.out.println(Math.log1p(4));
    }

    private int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(26, s.length() - i - 1) * ((byte) s.charAt(i) - 64);
        }
        return sum;
    }
}
