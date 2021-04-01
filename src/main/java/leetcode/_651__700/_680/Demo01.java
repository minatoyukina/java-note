package leetcode._651__700._680;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("aba"));
    }

    private boolean validPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return test(s.toCharArray(), t.toCharArray()) || test(t.toCharArray(), s.toCharArray());
    }

    private boolean test(char[] c1, char[] c2) {
        int a = 0, b = 0;
        boolean changed = false;
        while (a < c1.length && b < c2.length) {
            if (c1[a] != c2[b]) {
                if (c2[b] == ' ') b++;
                else {
                    if (changed) return false;
                    c2[c2.length - 1 - a] = ' ';
                    changed = true;
                    b--;
                }
            }
            a++;
            b++;
        }
        return true;
    }

}