package leetcode._451__500._483;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(smallestGoodBase("13"));
        System.out.println(smallestGoodBase("3"));

    }

    private String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long max = (long) Math.floor(Math.log(num) / Math.log(2));
        for (long l = max; l > 1; l--) {
            int k = (int) Math.pow(num, 1.0 / l);
            long mul = 1, sum = 1;
            for (long i = 0; i < l; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == num) {
                return Integer.toString(k);
            }
        }
        return Long.toString(num - 1);
    }

}