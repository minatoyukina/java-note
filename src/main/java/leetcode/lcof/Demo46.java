package leetcode.lcof;

import org.junit.Test;

public class Demo46 {

    @Test
    public void test() {
        System.out.println(translateNum(12258));
        System.out.println(translateNum(506));
    }

    private int translateNum(int num) {
        if (num < 10) return 1;
        if (num % 100 > 25 || num % 100 < 10) return translateNum(num / 10);
        else return translateNum(num / 10) + translateNum(num / 100);
    }
}
