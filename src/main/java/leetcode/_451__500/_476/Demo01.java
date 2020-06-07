package leetcode._451__500._476;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }

    private int findComplement(int num) {
        String s = Integer.toString(num, 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') sb.append(0);
            else sb.append(1);
        }
        return Integer.parseInt(sb.toString(), 2);
    }

}
