package leetcode._2001__2050._2028;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(missingRolls(new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5}, 4, 40)));
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int s1 = Arrays.stream(rolls).sum(), sum = mean * (rolls.length + n), s2 = sum - s1;
        if (s2 > n * 6 || s2 < n) return new int[0];
        int[] ans = new int[n];
        int avg = s2 / n;
        for (int i = 0; i < n; i++) {
            ans[i] = i == n - 1 ? s2 : avg;
            if (i != n - 1) s2 -= ans[i];
        }
        if (s2 > 6) {
            ans[n - 1] = 6;
            for (int i = 0; i < s2 - 6; i++) ans[i] += 1;
        }
        return ans;
    }

}
