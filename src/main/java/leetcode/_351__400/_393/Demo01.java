package leetcode._351__400._393;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(validUtf8(new int[]{333}));
        System.out.println(validUtf8(new int[]{197, 130, 1}));
        System.out.println(validUtf8(new int[]{235, 140, 4}));
    }

    private boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int d = data[i];
            String s = toBinary(d);
            if (s.startsWith("110")) {
                if (i + 1 >= data.length || !toBinary(data[i + 1]).startsWith("10")) return false;
                i += 1;
            }
            if (s.startsWith("1110")) {
                if (i + 2 >= data.length) return false;
                for (int j = 0; j < 2; j++) {
                    if (!toBinary(data[i + 1 + j]).startsWith("10")) return false;
                }
                i += 2;
            }
            if (s.startsWith("11110")) {
                if (i + 3 >= data.length) return false;
                for (int j = 0; j < 3; j++) {
                    if (!toBinary(data[i + 1 + j]).startsWith("10")) return false;
                }
                i += 3;
            }
            if (s.startsWith("10") || s.startsWith("11111")) return false;
        }
        return true;
    }

    private String toBinary(int d) {
        String s = Integer.toBinaryString(d);
        if (s.length() < 8) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8 - s.length(); j++) sb.append("0");
            s = sb.append(s).toString();
        }
        return s;
    }

}