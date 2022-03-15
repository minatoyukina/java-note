package leetcode._1401__1450._1432;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxDiff(9288));
        System.out.println(maxDiff(9));
        System.out.println(maxDiff(555));
    }

    public int maxDiff(int num) {
        int max = Integer.MIN_VALUE, len = String.valueOf(num).length();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                String s1 = String.valueOf(num).replace(String.valueOf(x), String.valueOf(y));
                int i1 = Integer.parseInt(s1);
                if (i1 == 0 || String.valueOf(i1).length() < len) continue;
                for (int a = 0; a < 10; a++) {
                    for (int b = 0; b < 10; b++) {
                        String s2 = String.valueOf(num).replace(String.valueOf(a), String.valueOf(b));
                        int i2 = Integer.parseInt(s2);
                        if (i2 == 0 || String.valueOf(i2).length() < len) continue;
                        max = Math.max(max, i1 - i2);
                    }
                }
            }
        }
        return max;
    }

}