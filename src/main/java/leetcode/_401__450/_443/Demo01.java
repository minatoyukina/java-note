package leetcode._401__450._443;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'}));
    }

    private int compress(char[] chars) {
        if (chars.length < 2) return chars.length;
        char c = chars[chars.length - 1];
        int count = 1;
        int res = 0;
        int offset = chars.length - 1;
        for (int i = chars.length - 2; i >= -1; i--) {

            char x = i == -1 ? ' ' : chars[i];
            if (x == c) {
                count++;
            }
            if (x != c || i == -1) {
                if (count > 1) {
                    String s = String.valueOf(count);
                    res += s.length() + 1;
                    char[] array = s.toCharArray();
                    int o = i + 2;
                    for (char a : array) {
                        chars[o] = a;
                        o++;
                    }
                    for (int j = o, t = o + chars.length - offset; j < t && t < chars.length; j++) {
                        chars[j] = chars[offset++];
                    }
                } else {
                    res += 1;
                }
                c = x;
                count = 1;
                offset = i + 1;
            }
        }
        return res;
    }

}
