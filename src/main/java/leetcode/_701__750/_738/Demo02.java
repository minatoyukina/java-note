package leetcode._701__750._738;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(963856657));
    }

    private int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i + 1] < chars[i]) {
                int x = i;
                while (x >= 1 && chars[x - 1] == chars[x]) x--;
                N = Integer.parseInt(s.substring(0, x + 1)) * (int) Math.pow(10, s.length() - x - 1);
                return N - 1;
            }
        }
        return N;
    }
}