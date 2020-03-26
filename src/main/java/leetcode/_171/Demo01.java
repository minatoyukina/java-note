package leetcode._171;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("AZZ"));
        System.out.println(convertToTitle(titleToNumber("AZZS")));
    }

    private int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(26, s.length() - i - 1) * ((byte) s.charAt(i) - 64);
        }
        return sum;
    }

    private String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, (char) ((n % 26 == 0 ? 26 : n % 26) + 64));
            n = n % 26 == 0 ? n / 26 - 1 : n / 26;
        }
        return sb.toString();
    }
}
