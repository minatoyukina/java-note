package leetcode._1__50._29;

import org.junit.Test;

import java.math.BigDecimal;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-10, 3));
    }

    private int divide(int dividend, int divisor) {
        BigDecimal divide = new BigDecimal(dividend).divide(new BigDecimal(divisor), BigDecimal.ROUND_DOWN);
        if (divide.doubleValue() < Integer.MIN_VALUE || divide.doubleValue() > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return divide.intValue();
    }
}
