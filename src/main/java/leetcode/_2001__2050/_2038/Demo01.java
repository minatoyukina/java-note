package leetcode._2001__2050._2038;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(winnerOfGame("BABBA"));
        System.out.println(winnerOfGame("BBAAABBABBABB"));
    }

    public boolean winnerOfGame(String colors) {
        int left = 0, aCount = 0, bCount = 0;
        char pre = colors.charAt(0);
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != pre || i == colors.length() - 1) {
                int right = i == colors.length() - 1 && c == pre ? i : (i - 1);
                if (right - left > 1) {
                    if (colors.charAt(right) == 'A') aCount += right - left - 1;
                    else bCount += right - left - 1;
                }
                left = i;

            }
            pre = c;
        }
        return aCount > bCount;
    }
}
