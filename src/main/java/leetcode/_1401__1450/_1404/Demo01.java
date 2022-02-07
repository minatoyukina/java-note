package leetcode._1401__1450._1404;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSteps("1110"));
        System.out.println(numSteps("10"));
    }

    public int numSteps(String s) {
        int step = 0;
        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            int pos = 0;
            boolean carry = false;
            while (pos < s.length()) {
                sb.append(carry ? 1 : sb.length() == 0 ? "" : "0");
                carry = s.charAt(pos++) == '1';
            }
            if (s.endsWith("1")) {
                int i = sb.lastIndexOf("0");
                for (int x = i + 1; x < sb.length(); x++) sb.replace(x, x + 1, "0");
                if (i == -1) sb.insert(0, '1');
                else sb.replace(i, i + 1, "1");
                step++;
            }
            s = sb.toString();
            step++;
        }
        return step;
    }


}