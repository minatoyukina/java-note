package leetcode._451__500._467;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findSubstringInWraproundString("zab"));
        System.out.println(findSubstringInWraproundString("yhxtdobyly"));
    }

    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        int[] max = new int[26];
        int[] dp = new int[n];
        max[p.charAt(0) - 'a'] = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            char a = p.charAt(i - 1), b = p.charAt(i);
            if (b == a + 1 || (b == 'a' && a == 'z')) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            max[b - 'a'] = Math.max(max[b - 'a'], dp[i]);
        }
        return Arrays.stream(max).sum();
    }

}