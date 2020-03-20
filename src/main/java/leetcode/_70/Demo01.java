package leetcode._70;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(45));
        System.out.println(climbStairs(46));
    }

    private int climbStairs(int n) {
        if (n <= 2) return n;
        int pre = 1;
        int next = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = pre + next;
            pre = next;
            next = sum;
        }
        return sum;
//        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
