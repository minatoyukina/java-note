package leetcode._401__450._402;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(removeKdigits("3542119", 3));
        System.out.println(removeKdigits("10000", 1));
    }

    private String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        char[] chars = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int remain = chars.length - k;
        for (int i = 0; i < chars.length; i++) {
            if (remain == 0) break;
            char min = Character.MAX_VALUE;
            if (remain > chars.length - 1 - pos) {
                sb.append(num.substring(pos));
                break;
            }
            for (int j = i; j <= chars.length - remain; j++) {
                if (chars[j] < min) {
                    min = chars[j];
                    pos = j;
                }
            }
            if (min != Character.MAX_VALUE) {
                sb.append(min);
                remain--;
            }
            i = pos++;
        }
        char[] arr = sb.toString().toCharArray();
        int offset = 0;
        for (char c : arr) {
            if (c == '0') offset++;
            else break;
        }
        String substring = sb.substring(offset);
        return substring.equals("") ? "0" : substring;
    }

}
