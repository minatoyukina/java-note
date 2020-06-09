package leetcode._921;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
    }

    private int minAddToMakeValid(String S) {
        while (S.contains("()")) S = S.replace("()", "");
        return S.length();
    }

}
