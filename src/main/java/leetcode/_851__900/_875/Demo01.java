package leetcode._851__900._875;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minEatingSpeed(new int[]{312884470}, 968709470));
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    private int minEatingSpeed(int[] piles, int h) {
        int right = IntStream.of(piles).max().orElse(0);
        int left = (int) (Arrays.stream(piles).mapToLong(x -> (long) x).sum() / h);
        left = left == 0 ? 1 : left;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, piles, h)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int x, int piles[], int h) {
        for (int pile : piles) h -= (pile - 1) / x + 1;
        return h >= 0;
    }

}