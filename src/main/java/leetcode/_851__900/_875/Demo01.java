package leetcode._851__900._875;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    private int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long sum = 0;
        for (int pile : piles) sum += pile;
        if (sum <= h) return 1;
        int remain = h;
        label:
        for (int i = (int) (sum / h); i <= piles[piles.length - 1]; i++) {
            for (int j = piles.length - 1; j >= 0; j--) {
                int pile = piles[j];
                if (pile <= i && remain - j >= 0) {
                    return i;
                }
                remain -= pile % i == 0 ? pile / i : (pile / i + 1);
                if (remain < 0) {
                    remain = h;
                    continue label;
                }
            }
            return i;
        }
        return piles[piles.length - 1];
    }

}