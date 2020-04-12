package leetcode._50__100._67;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(addBinary("1", "11"));
        System.out.println(addBinary("1010", "1011"));
    }

    private String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(a.length(), b.length());
        if (a.length() > min) {
            sb.append(a, 0, a.length() - min);
            a = a.substring(a.length() - min);
        } else {
            sb.append(b, 0, b.length() - min);
            b = b.substring(b.length() - min);
        }
        for (int i = 0; i < min; i++) {
            sb.append(Integer.parseInt(a.charAt(i) + "") + Integer.parseInt(b.charAt(i) + ""));
        }
        for (int j = sb.length() - 1; j >= 1; j--) {
            int x = Integer.parseInt(sb.charAt(j) + "");
            int y = Integer.parseInt(sb.charAt(j - 1) + "");
            if (x >= 2) {
                sb.replace(j, j + 1, x - 2 + "");
                sb.replace(j - 1, j, y + 1 + "");
            }
        }
        if (sb.charAt(0) == '2') {
            sb.replace(0, 1, "10");
        }
        if (sb.charAt(0) == '3') {
            sb.replace(0, 1, "11");
        }
        return sb.toString();
    }
}
