package leetcode._1__50._50;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
    }

    private double myPow(double x, int n) {
//        double answer = 1;
//        if (n < 0) {
//            for (int i = 0; i < -n; i++) {
//                answer *= 1.0 / x;
//            }
//        }
//        if (n == 0) {
//            return 0;
//        }
//        if (n > 0) {
//            for (int i = 0; i < n; i++) {
//                answer *= x;
//            }
//        }
//        return answer;
        return Math.pow(x, n);
    }
}
