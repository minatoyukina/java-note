package leetcode._251__300._279;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSquares(13));
        System.out.println(numSquares(18));
    }

    private int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (n == sqrt * sqrt) return 1;
        for (int i = 1; i <= sqrt; i++) {
            int x = (int) Math.sqrt(n - i * i);
            if (n == i * i + x * x) return 2;
        }
        for (int i = 1; i <= sqrt; i++) {
            for (int j = 1; j <= sqrt; j++) {
                int y = (int) Math.sqrt(n - i * i - j * j);
                if (n == i * i + j * j + y * y) return 3;
            }
        }
        return 4;
    }

}
