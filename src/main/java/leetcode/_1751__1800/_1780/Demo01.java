package leetcode._1751__1800._1780;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkPowersOfThree((int) 1e7));
    }

    public boolean checkPowersOfThree(int n) {
        return dfs(n, 14);
    }

    public boolean dfs(int n, int max) {
        for (int i = max; i >= 0; i--) {
            int pow = (int) Math.pow(3, i);
            if (pow > n) continue;
            if (dfs(n - pow, i - 1)) return true;
        }
        return n == 0;
    }

}