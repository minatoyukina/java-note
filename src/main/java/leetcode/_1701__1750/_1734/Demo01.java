package leetcode._1701__1750._1734;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(decode(new int[]{6, 5, 4, 6})));
    }

    private int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int tot = 0;
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) tot ^= i;
        for (int i = 1; i < n - 1; i += 2) tot ^= encoded[i];
        ans[0] = tot;
        for (int i = 1; i < n; i++) ans[i] = ans[i - 1] ^ encoded[i - 1];
        return ans;
    }

}