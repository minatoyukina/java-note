package leetcode._1__50._8;

import org.junit.Test;

import java.math.BigDecimal;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("    -42"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-3.14"));
        System.out.println(myAtoi("+3"));
        System.out.println(myAtoi("+-3"));
        System.out.println(myAtoi(""));
    }

    private int myAtoi(String str) {
        String trim = str.trim();
        String replace = trim;
        if (trim.startsWith("+")) {
            replace = trim.substring(1);
        } else if (trim.startsWith("-")) {
            replace = replace.substring(1);
        }
        StringBuilder num = new StringBuilder();
        if (replace.equals("")) {
            return 0;
        }
        for (int i = 0; i < replace.length(); i++) {
            try {
                Integer.parseInt(replace.charAt(i) + "");
            } catch (NumberFormatException e) {
                if (i == 0) {
                    return 0;
                } else {
                    break;
                }
            }
            num.append(replace.charAt(i));
        }
        String answer = trim.startsWith("-") ? "-" + num.toString() : num.toString();
        BigDecimal bigDecimal = new BigDecimal(answer);
        if (bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        }
        if (bigDecimal.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(answer);
    }
}
