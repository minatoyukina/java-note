package leetcode._551__600._592;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(fractionAddition("1/3-1/2"));
        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
    }

    private String fractionAddition(String expression) {
        expression = expression.startsWith("-") ? expression : ("+" + expression);
        return helper(0, 1, expression);
    }

    private String helper(int a, int b, String expression) {
        if (expression.length() == 0) {
            if (a == 0) return "0/1";
            int i = maxGCD(Math.abs(a), b);
            return a / i + "/" + b / i;
        }
        int index = expression.length();
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-') {
                index = i;
                break;
            }
        }
        String s1 = expression.substring(1, index);
        String s2 = expression.substring(index);
        String[] split = s1.split("/");
        int c = Integer.parseInt(split[0]), d = Integer.parseInt(split[1]);
        if (expression.startsWith("+")) return helper(a * d + b * c, d * b, s2);
        else return helper(a * d - b * c, d * b, s2);
    }

    private int maxGCD(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b != 0) return maxGCD(b, a % b);
        return b;
    }

}
