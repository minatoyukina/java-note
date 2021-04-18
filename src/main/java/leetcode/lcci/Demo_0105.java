package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0105 {

    @Test
    public void test() {
        System.out.println(oneEditAway("", "a"));
        System.out.println(oneEditAway("fuck", "funk"));
    }

    private boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }
        if (first.length() - second.length() > 1) return false;
        boolean changed = false;
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i++) != second.charAt(j++)) {
                if (changed) return false;
                if (first.length() != second.length()) j--;
                changed = true;
            }
        }
        return true;
    }
}
