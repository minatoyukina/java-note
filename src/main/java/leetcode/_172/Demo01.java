package leetcode._172;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(trailingZeroes(6));
        System.out.println(trailingZeroes(5937));
    }

    private int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
//        BigDecimal f = new BigDecimal(1);
//        for (int i = 1; i <= n; i++) {
//            f = f.multiply(new BigDecimal(i));
//        }
//        int count = 0;
//        for (int i = f.toString().length() - 1; i >= 0; i--) {
//            if (f.toString().charAt(i) == '0') count++;
//            else break;
//        }
//        return count;
    }
}
