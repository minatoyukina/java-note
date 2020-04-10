package leetcode._1__50._28;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("", "a"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("a", "a"));
    }

    private int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int l = needle.length();
        for (int i = 0; i < haystack.length() - l + 1; i++) {
            if (haystack.substring(i, i + l).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
