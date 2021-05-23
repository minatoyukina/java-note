package leetcode._51__100._65;

import org.junit.Test;

public class Demo01 {


    @Test
    public void testCut() {
        System.out.println(isNumber("1e9+7"));
        System.out.println(isNumber("+3.4"));
        System.out.println(isNumber("-3"));
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
