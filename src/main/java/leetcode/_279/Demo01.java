package leetcode._279;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
//        System.out.println(numSquares(13));
        System.out.println(numSquares(20));
    }

    private int numSquares(int n) {
        return numSquares(n, 0);
    }

    private int numSquares(int n, int count) {
        if (n <= 3) return count + n;
        int sqrt = (int) Math.sqrt(n);
        int a = n;
        int x = n;
        for (int i = sqrt; i > 0; i--) {
            int tmp = i * i;
            int b = n / tmp + (n % tmp);
            if (b < a) {
                a = b;
                x = i;
            }
        }
        System.out.println(x * x);
        return numSquares(n - x * x, ++count);
    }

}
