package leetcode._717;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isOneBitCharacter(new int[]{0, 1, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{0, 1, 0, 0}));
    }

    private boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) return true;
        int i = bits.length - 2, count = 0;
        while (i >= 0 && bits[i--] == 1) count++;
        return count % 2 == 0;
    }


}
