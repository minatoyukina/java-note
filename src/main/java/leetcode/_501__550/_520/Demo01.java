package leetcode._501__550._520;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("aPPle"));
        System.out.println(detectCapitalUse("ggg"));
    }

    private boolean detectCapitalUse(String word) {
        int length = word.length();
        if (length < 2) return true;
        boolean first = isUpperCase(word.charAt(0)), second = isUpperCase(word.charAt(1));
        if (!first) {
            for (int i = 1; i < length; i++) if (isUpperCase(word.charAt(i))) return false;
        } else {
            if (second) {
                for (int i = 2; i < length; i++) if (!isUpperCase(word.charAt(i))) return false;
            } else {
                for (int i = 2; i < length; i++) if (isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    private boolean isUpperCase(char c) {
        int a = (int) c;
        return a >= 65 && a <= 90;
    }

}
