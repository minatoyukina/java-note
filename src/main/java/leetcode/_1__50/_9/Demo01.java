package leetcode._1__50._9;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
    }

    private boolean isPalindrome(int x) {
        return new StringBuilder(x + "").reverse().toString().equals(x + "");
    }
}
