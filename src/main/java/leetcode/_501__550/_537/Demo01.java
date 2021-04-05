package leetcode._501__550._537;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
    }

    private String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int x1 = Integer.parseInt(as[0]);
        int y1 = Integer.parseInt(as[1].replace("i", ""));
        int x2 = Integer.parseInt(bs[0]);
        int y2 = Integer.parseInt(bs[1].replace("i", ""));
        return x1 * x2 - y1 * y2 + "+" + (x1 * y2 + x2 * y1) + "i";
    }

}
