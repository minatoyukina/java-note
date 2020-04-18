package leetcode._101__150._125;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("`l;`` 1o1 ??;l`"));
    }

    private boolean isPalindrome(String s) {
        s = s.toUpperCase().replaceAll("\\s+", "").replace("`", "").replaceAll("\\p{P}", "");
        System.out.println(s);
        List<Integer> list = new LinkedList<>();
        ((LinkedList<Integer>) list).pollFirst();
        return new StringBuilder(s).reverse().toString().equals(s);
    }

}
