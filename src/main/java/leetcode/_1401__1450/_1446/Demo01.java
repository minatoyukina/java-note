package leetcode._1401__1450._1446;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("a"));
    }

    public int maxPower(String s) {
        int max = 1, count = 1;
        int pos = 0;
        while (pos < s.length()) {
            if (pos + 1 < s.length() && s.charAt(pos + 1) == s.charAt(pos)) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
            pos++;
        }
        return max;
    }

}