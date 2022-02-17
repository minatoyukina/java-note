package leetcode._1901__1950._1946;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumNumber("3765475447", new int[]{4, 2, 1, 0, 4, 7, 0, 9, 5, 2}));
        System.out.println(maximumNumber("132", new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
    }

    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        int pos = -1;
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - '0';
            if (change[c] > c && (pos == -1 || pos == i - 1)) {
                chars[i] = Character.forDigit(change[c], 10);
                pos = i;
            } else if (change[c] == c) if (pos != -1 && pos == i - 1) pos = i;
        }
        return new String(chars);
    }

}