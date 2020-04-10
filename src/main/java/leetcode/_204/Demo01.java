package leetcode._204;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(countPrimes(499979));
        System.out.println(countPrimes(10));
    }


    private int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 1;
        for (int i = 2; i < n; i++) {
            int sqrt = (int) Math.sqrt(i) + 1;
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) break;
                if (j == sqrt) count++;
            }
        }
        return count;
    }
}
