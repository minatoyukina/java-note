package leetcode._201__250._233;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countDigitOne(20));
        System.out.println(countDigitOne(13));
    }

    private int countDigitOne(int n) {
        int ans = 0, pre = 0;
        while (n > 0) {
            int remain = n % 10;
            ans = pre + 1 + 2 * ans;
            n /= 10;
            pre += pre == 0 ? remain : 10 * remain;
            if (pre == 0) pre = -1;
        }
        return ans;
    }

}