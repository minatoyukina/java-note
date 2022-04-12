package leetcode._1451__1500._1461;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(hasAllCodes("01101100", 2));
    }

    public boolean hasAllCodes(String s, int k) {
        boolean[] arr = new boolean[(int) Math.pow(2, k)];
        for (int i = k; i <= s.length(); i++) {
            String ss = s.substring(i - k, i);
            arr[Integer.parseInt(ss, 2)] = true;
        }
        for (boolean b : arr) if (!b) return false;
        return true;
    }

}