package leetcode._601__650._640;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation("x=x"));
        System.out.println(solveEquation("x=x+2"));
        System.out.println(solveEquation("-x=-1"));
    }

    private String solveEquation(String equation) {
        equation = equation.replace("-", "+-");
        String[] split = equation.split("=");
        String[] left = split[0].split("\\+");
        String[] right = split[1].split("\\+");
        int x = 0;
        int y = 0;
        for (String s : left) {
            if (s.equals("")) continue;
            if (s.equals("x")) s = "1x";
            if (s.equals("-x")) s = "-1x";
            if (s.contains("x")) x += (Integer.parseInt(s.substring(0, s.length() - 1)));
            else y -= Integer.parseInt(s);
        }
        for (String s : right) {
            if (s.equals("")) continue;
            if (s.equals("x")) s = "1x";
            if (s.equals("-x")) s = "-1x";
            if (s.contains("x")) x -= (Integer.parseInt(s.substring(0, s.length() - 1)));
            else y += Integer.parseInt(s);
        }
        return x == 0 ? (y == 0 ? "Infinite solutions" : "No solution") : "x=" + String.valueOf(y / x);
    }


}
