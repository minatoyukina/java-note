package leetcode._401__450._415;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(addStrings("45", "123"));
        System.out.println(123 + 45);
        System.out.println(addStrings("9999", "46"));
        System.out.println(9999 + 46);
    }

    private String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        num1 = "0" + num1;
        StringBuilder sb = new StringBuilder(num2);
        for (int i = 0; i < num1.length() - num2.length(); i++) {
            sb.insert(0, "0");
        }
        num2 = sb.toString();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        boolean ceiling = false;
        for (int i = c1.length - 1; i >= 1; i--) {
            int x = c1[i] + c2[i] - 96 + (ceiling ? 1 : 0);
            if (x >= 10) {
                ceiling = true;
                c1[i] = (char) (x + 38);
            } else {
                ceiling = false;
                c1[i] = (char) (x + 48);
            }
        }
        return (ceiling ? "1" : "") + String.valueOf(c1, 1, c1.length - 1);
    }

}