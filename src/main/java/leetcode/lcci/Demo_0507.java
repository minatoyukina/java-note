package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0507 {

    @Test
    public void test() {
        System.out.println(exchangeBits(0));
        System.out.println(exchangeBits(2));
    }

    private int exchangeBits(int num) {
        String s = Integer.toBinaryString(num);
        if (s.length() % 2 == 1) s = "0" + s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            char c = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = c;
        }
        return Integer.parseInt(new String(chars), 2);
    }

}
