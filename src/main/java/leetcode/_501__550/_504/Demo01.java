package leetcode._501__550._504;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }

    private String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = num < 0;
        num = Math.abs(num);
        int off = 0;
        int tmp = num;
        while (tmp >= 7) {
            off++;
            tmp /= 7;
        }
        while (off >= 0) {
            int x = (int) (num / Math.pow(7, off));
            sb.append(x);
            num -= x * Math.pow(7, off);
            off--;
        }
        return (flag ? "-" : "") + sb.toString();
    }

}
