package leetcode._1051__1100._1071;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {

        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("AAAAAA", "AA"));
    }

    private String gcdOfStrings(String str1, String str2) {
        for (int i = str2.length(); i >= 1; i--)
            if (str2.length() % i == 0) {
                String substring = str2.substring(0, i);
                if (str2.replace(substring, "").isEmpty() && str1.replace(substring, "").isEmpty()) return substring;
            }
        return "";
    }

}
