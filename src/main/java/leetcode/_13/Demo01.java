package leetcode._13;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private int romanToInt(String s) {
        s = s.replace("CD", "CCCC")
                .replace("CM", "DCCCC")
                .replace("XL", "XXXX")
                .replace("XC", "LXXXX")
                .replace("IV", "IIII")
                .replace("IX", "VIIII");
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    answer += 1;
                    break;
                case 'V':
                    answer += 5;
                    break;
                case 'X':
                    answer += 10;
                    break;
                case 'L':
                    answer += 50;
                    break;
                case 'C':
                    answer += 100;
                    break;
                case 'D':
                    answer += 500;
                    break;
                case 'M':
                    answer += 1000;
                    break;
            }
        }
        return answer;
    }

}
