package leetcode._151__200._190;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(reverseBits(1234));
        System.out.println(reverseBits(4294967));
    }

    private int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
