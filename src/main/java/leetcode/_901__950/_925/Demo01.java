package leetcode._901__950._925;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isLongPressedName("saeedi", "ssaaeediixxxiii"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
    }

    private boolean isLongPressedName(String name, String typed) {
        int left = 0, right = 0;
        int m = name.length(), n = typed.length();
        if (name.charAt(left) != typed.charAt(right)) return false;
        while (left < m && right < n) {
            if (name.charAt(left) == typed.charAt(right)) {
                left++;
                right++;
                if (left == m) while (right < n && typed.charAt(right - 1) == typed.charAt(right)) right++;
            } else {
                while (right < n && name.charAt(left) != typed.charAt(right)) {
                    if (typed.charAt(right - 1) != typed.charAt(right)) return false;
                    right++;
                }
            }
        }
        return left == m && right == n;
    }
}