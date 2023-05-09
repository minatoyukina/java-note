package leetcode._2301__2350._2401__2450._2437;

import org.junit.Test;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(countTime("2?:??"));
        System.out.println(countTime("0?:0?"));
    }


    public int countTime(String time) {
        char a = time.charAt(0), b = time.charAt(1), c = time.charAt(3), d = time.charAt(4);
        int l = 1, r = 1;
        if (a == '?' && b == '?') l = 24;
        else if (a == '?') l = b >= '4' ? 2 : 3;
        else if (b == '?') l = a == '2' ? 4 : 10;
        if (c == '?' && d == '?') r = 60;
        else if (c == '?') r = 6;
        else if (d == '?') r = 10;
        return l * r;
    }

}
