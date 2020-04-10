package leetcode._1__50._12;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(1994));
    }

    private String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();
        while (num - 1000 >= 0) {
            answer.append("M");
            num -= 1000;
        }
        while (num - 500 >= 0) {
            answer.append("D");
            num -= 500;
        }
        while (num - 100 >= 0) {
            answer.append("C");
            num -= 100;
        }
        while (num - 50 >= 0) {
            answer.append("L");
            num -= 50;
        }
        while (num - 10 >= 0) {
            answer.append("X");
            num -= 10;
        }
        while (num - 5 >= 0) {
            answer.append("V");
            num -= 5;
        }
        while (num - 1 >= 0) {
            answer.append("I");
            num -= 1;
        }
        return answer.toString()
                .replaceAll("VIIII", "IX")
                .replaceAll("IIII", "IV")
                .replaceAll("LXXXX", "XC")
                .replaceAll("XXXX", "XL")
                .replaceAll("DCCCC", "CM")
                .replaceAll("CCCC", "CD");
    }

}
