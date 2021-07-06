package leetcode._751__800._768;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(rotatedDigits(10));
        System.out.println(rotatedDigits(11));
    }

    private int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) if (check(i)) ans++;
        return ans;
    }

    private boolean check(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '2') chars[i] = '5';
            else if (c == '5') chars[i] = '2';
            else if (c == '6') chars[i] = '9';
            else if (c == '9') chars[i] = '6';
            else if (c == '3' || c == '4' || c == '7') return false;
        }
        return Integer.parseInt(new String(chars)) != n;
    }

}