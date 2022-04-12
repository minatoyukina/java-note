package leetcode._351__400._397;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(integerReplacement(Integer.MAX_VALUE));
        System.out.println(integerReplacement(8));
    }

    public int integerReplacement(int n) {
        return dfs(n);
    }

    private int dfs(long n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return dfs(n / 2) + 1;
        return Math.min(dfs(n + 1), dfs(n - 1)) + 1;
    }

}