package leetcode._151__200._190;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(reverseBits(1234));
        System.out.println(reverseBits(4294967293L));
    }

    private long reverseBits(long n) {
        String s1 = Long.toBinaryString(n);
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < 32 - s1.length(); i++) {
            s2.append("0");
        }
        System.out.println(s2 + s1);
        return Long.valueOf(new StringBuilder(s2 + s1).reverse().toString(), 2);
    }
}
