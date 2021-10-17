package leetcode._601__650._639;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numDecodings("*1*"));
        System.out.println(numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
        System.out.println(numDecodings("*********"));
    }

    public int numDecodings(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        if (n == 1) return count(s.charAt(0));
        if (n == 2) return count(s.charAt(0)) * count(s.charAt(1)) + count(s.charAt(0), s.charAt(1));
        int[] dp = new int[n];
        dp[0] = count(s.charAt(0));
        dp[1] = count(s.charAt(0)) * count(s.charAt(1)) + count(s.charAt(0), s.charAt(1));
        for (int i = 2; i < n; i++) {
            char a = s.charAt(i - 1), b = s.charAt(i);
            dp[i] = (int) ((long) count(b) * dp[i - 1] % mod + (long) count(a, b) * dp[i - 2] % mod);
            dp[i] %= mod;
        }
        return dp[n - 1];
    }

    private int count(char a) {
        if (a == '0') return 0;
        if (a == '*') return 9;
        return 1;
    }

    private int count(char a, char b) {
        if (a == '*' && b == '*') return 15;
        else if (a == '*') {
            if (b > '6') return 1;
            else return 2;
        } else if (b == '*') {
            if (a > '2' || a == '0') return 0;
            else if (a == '1') return 9;
            else return 6;
        } else {
            if (a > '2' || a == '0') return 0;
            else if (a == '2' && b > '6') return 0;
            else return 1;
        }
    }

}