package leetcode._201__250._233;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(0));
    }

    private int countDigitOne(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') ans++;
            }
        }
        return ans;
    }

}