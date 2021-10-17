package leetcode._501__550._526;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countArrangement(4));
    }


    public int countArrangement(int n) {
        return dfs(1, 0, n);
    }

    private int dfs(int pos, int bin, int n) {
        if (pos > n) return bin == (2 << n - 1) - 1 ? 1 : 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if ((bin >> i - 1 & 1) == 0 && (Math.max(i, pos) % Math.min(i, pos) == 0)) {
                sum += dfs(pos + 1, bin | (1 << i - 1), n);
            }
        }
        return sum;
    }
}