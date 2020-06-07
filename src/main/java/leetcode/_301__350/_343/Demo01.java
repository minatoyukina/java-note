package leetcode._301__350._343;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(10));
    }

    private int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int ans = 0;
        for (int i = 2; i <= n / 2; i++) {
            int x = n / i;
            int a = i * x + i - n;
            int b = n - i * x;
            ans = Math.max((int) Math.pow(x, a) * (int) Math.pow(x + 1, b), ans);
        }
        return ans;
    }
}
