package leetcode._1401__1450._1422;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxScore("011101"));
    }

    public int maxScore(String s) {
        int left = 0, right = (int) s.chars().filter(x -> x == '1').count();
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') left++;
            else right--;
            max = Math.max(max, left + right);
        }
        return max;
    }

}