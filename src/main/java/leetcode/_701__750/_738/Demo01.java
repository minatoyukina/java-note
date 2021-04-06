package leetcode._701__750._738;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(963856657));
    }

    private int monotoneIncreasingDigits(int N) {
        for (int n = N; n >= 0; n--) {
            String s = String.valueOf(n);
            boolean flag = true;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i + 1) < s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return n;
        }
        return 0;
    }
}