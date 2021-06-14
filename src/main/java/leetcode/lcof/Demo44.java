package leetcode.lcof;

import org.junit.Test;

public class Demo44 {

    @Test
    public void test() {
        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(10));
        System.out.println(findNthDigit(11));
    }

    private int findNthDigit(int n) {
        int bit = 1, sum = 0;
        while (n >= sum + bit * (bit == 1 ? 10 : 9 * Math.pow(10, bit - 1))) {
            sum += bit * (bit == 1 ? 10 : 9 * Math.pow(10, bit - 1));
            bit++;
        }
        int pre = (n - sum) / bit;
        int cur = (bit == 1 ? 0 : (int) Math.pow(10, bit - 1)) + pre;
        return Integer.toString(cur).toCharArray()[(n - sum) % bit] - '0';
    }
}
