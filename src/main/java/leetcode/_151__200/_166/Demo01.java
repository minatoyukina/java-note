package leetcode._151__200._166;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(fractionToDecimal(-2147483648, -1));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(22, 7));
        System.out.println(fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal(1, 214748364));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0) return String.valueOf((long) numerator / denominator);
        boolean diff = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0);
        long a = Math.abs((long) numerator), b = Math.abs((long) denominator);
        long pre = 0, suf = a;
        Map<Long, Integer> map = new HashMap<>();
        if (a > b) {
            pre = a / b;
            suf = a % b;
        }
        StringBuilder sb = new StringBuilder();
        String s = (diff ? "-" : "") + pre;
        int bit = 0;
        while (true) {
            while (suf * 10 < b) {
                suf *= 10;
                if (map.containsKey(suf))
                    return s + "." + sb.substring(0, map.get(suf)) + "(" + sb.substring(map.get(suf), bit) + ")";
                map.put(suf, bit);
                bit++;
                sb.append("0");
            }
            if (suf < b) suf *= 10;
            if (map.containsKey(suf))
                return s + "." + sb.substring(0, map.get(suf)) + "(" + sb.substring(map.get(suf), bit) + ")";
            map.put(suf, bit);
            sb.append(suf / b);
            suf %= b;
            if (suf == 0) return s + "." + sb;
            bit++;
        }
    }
}