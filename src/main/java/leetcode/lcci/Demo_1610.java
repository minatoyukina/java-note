package leetcode.lcci;

import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_1610 {

    @Test
    public void test() {
        System.out.println(maxAliveYear(new int[]{1900, 1901, 1950}, new int[]{1948, 1951, 2000}));
    }

    private int maxAliveYear(int[] birth, int[] death) {
        int n = birth.length, max = 0, ans = 0;
        for (int i = 1900; i < 2001; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (birth[j] <= i && death[j] >= i) count++;
            }
            if (count > max) {
                max = count;
                ans = i;
            }
        }
        return ans;
    }

}
