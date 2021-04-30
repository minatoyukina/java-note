package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1605 {

    @Test
    public void test() {
        System.out.println(trailingZeroes(15));
        System.out.println(trailingZeroes(25));
    }

    private int trailingZeroes(int n) {
        while (n % 5 != 0) n--;
        return 1;
    }
}
