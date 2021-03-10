package leetcode._1__50._43;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
    }

    private String multiply(String num1, String num2) {
        char[] chars = num1.toCharArray();
        String res = "0";
        for (int i = chars.length - 1; i >= 0; i--) {
            int x = chars[i] - '0';
            String tmp = "0";
            for (int k = 0; k < x; k++) {
                tmp = addStrings(tmp, num2);
            }
            StringBuilder sb = new StringBuilder(tmp);
            for (int j = 0; j < chars.length - 1 - i; j++) {
                sb.append("0");
            }
            res = addStrings(res, sb.toString());
        }
        if (res.replace("0", "").equals("")) return "0";
        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

}