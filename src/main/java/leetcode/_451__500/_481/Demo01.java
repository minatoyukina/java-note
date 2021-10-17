package leetcode._451__500._481;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(magicalString(16));
        System.out.println(magicalString(2));
    }

    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("1");
        int pos = 0, count = 1;
        while (sb.length() < n) {
            int x = pos++ == 0 ? 2 : sb.charAt(pos) - '0';
            boolean b = sb.charAt(sb.length() - 1) == '1';
            for (int i = 0; i < x; i++) {
                if (sb.length() >= n) break;
                if (b) sb.append("2");
                else {
                    count++;
                    sb.append("1");
                }
            }
        }
        return count;
    }

}