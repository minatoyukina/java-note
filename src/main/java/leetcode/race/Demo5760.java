package leetcode.race;

import org.junit.Test;

public class Demo5760 {

    @Test
    public void test() {
        System.out.println(minSwaps("100"));
        System.out.println(minSwaps("010"));
    }

    private int minSwaps(String s) {
        int one = 0, zero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else one++;
        }
        if (Math.abs(one - zero) > 1) return -1;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                a.append(1);
                b.append(0);
            } else {
                a.append(0);
                b.append(1);
            }
        }
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != a.charAt(i)) x++;
            if (c != b.charAt(i)) y++;
        }
        if (x % 2 != 0) return y / 2;
        if (y % 2 != 0) return x / 2;
        return Math.min(x, y) / 2;
    }
}
