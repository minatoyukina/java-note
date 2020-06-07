package leetcode._351__400._357;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(f(10, 0));
        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    private int countNumbersWithUniqueDigits(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) sum += 9 * f(9, i - 1);
        return sum;
    }

    private int f(int n, int k) {
        int ans = 1;
        for (int i = 0; i < k; i++) ans *= n - i;
        return ans;
    }
}
