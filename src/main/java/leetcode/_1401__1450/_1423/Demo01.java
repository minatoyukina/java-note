package leetcode._1401__1450._1423;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

    public int maxScore(int[] cardPoints, int k) {
        int left = Arrays.stream(cardPoints).limit(k).sum(), right = 0, max = left;
        for (int i = k - 1; i >= 0; i--) {
            left -= cardPoints[i];
            right += cardPoints[cardPoints.length - (k - i)];
            max = Math.max(max, left + right);
        }
        return max;
    }


}